import dao.StudentDAOImpl;
import model.Student;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {
    StudentDAOImpl dao = new StudentDAOImpl();
//    dao.createTable();
//
//    // add student
//    dao.addStudent(new Student(
//            "Pushan",
//            "Pushan@gmail.com",
//            98
//    ));

    System.out.println(dao.getAllStudents());

    dao.updateStudent(new Student(
            1, "Godse", "Godse@gmail.com", 85
    ));

    System.out.println(dao.getAllStudents());

    dao.deleteStudent(1);
}
