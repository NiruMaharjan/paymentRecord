/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paymentrecordassignment;

import com.leapfrog.DAO.EnrollmentDAO;
import com.leapfrog.DAO.PaymentDAO;
import com.leapfrog.DAO.StudentDAO;
import com.leapfrog.DAO.impl.EnrollmentDAOImpl;
import com.leapfrog.DAO.impl.PaymentDAOImpl;
import com.leapfrog.DAO.impl.StudentDAOImpl;
import com.leapfrog.entity.Batch;
import com.leapfrog.entity.Enrollment;
import com.leapfrog.entity.Payment;
import com.leapfrog.entity.Student;
import java.sql.SQLException;
import java.util.Scanner;

/**
 *
 * @author Lenovo
 */
public class PaymentRecordAssignment {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner input = new Scanner(System.in);
        StudentDAO studentDAO = new StudentDAOImpl();
        PaymentDAO paymentDAO = new PaymentDAOImpl();
        System.out.println("Student Id");
        int student_id = input.nextInt();
        try {
            Student student = studentDAO.getById(student_id);
            System.out.println(student.getFirst_name() + " " + student.getLast_name());
            System.out.println("Enter batch code");
            String batch_code = input.next();
            //Batch batch =new Batch();
            EnrollmentDAO enrollmentDAO = new EnrollmentDAOImpl();
            Enrollment enrollment = enrollmentDAO.getByBatchCode(batch_code, student.getId());
            if (enrollment != null) {

                System.out.println("Course:" + enrollment.getBatch().getCourse().getName());
                System.out.println("Fees:" + enrollment.getBatch().getCourse().getFees());
                System.out.println("Facilitator:" + enrollment.getBatch().getFacilitator().getName());
                Payment payment = paymentDAO.remainingAmount(enrollment.getId());
                int remainingAmount = payment.getRemaining();
                int totalPaidAmount = payment.getAmount();
                System.out.println("remaining amount" + remainingAmount);
                if (remainingAmount != 0 || totalPaidAmount == 0) {
                    System.out.println("Do you want to make payment?(y/n)");
                    if (input.next().equalsIgnoreCase("y")) {
                        payment = new Payment();
                        System.out.println("Enter your payment amount");
                        int paymentAmount = input.nextInt();
                        payment.setAmount(paymentAmount);

                        payment.setEnrollment(enrollment);
                        paymentDAO.insert(payment);
                        payment = paymentDAO.remainingAmount(enrollment.getId());

                        System.out.println("Thank you for making a payment");
                        //System.out.println("enrollment_id"+enrollment.getId());

                        System.out.println("Your remaining amount is " + payment.getRemaining());

                    }
                } else {
                    System.out.println("cleared");
                }

                // System.out.println( "Facilitator:"+enrollment.getBatch().getFacilitator().getFirst_name());
            } else {
                System.out.println("Input valid batch code");
            }

        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        }

    }

}
