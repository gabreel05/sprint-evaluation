package br.com.gabriel;

import java.time.LocalDate;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.gabriel.model.Course;
import br.com.gabriel.model.Student;
import br.com.gabriel.model.Subject;
import br.com.gabriel.model.SubjectDetail;
import br.com.gabriel.model.SubjectDetailPK;
import br.com.gabriel.model.Teacher;
import br.com.gabriel.model.Team;
import br.com.gabriel.model.TeamDetail;
import br.com.gabriel.model.TeamDetailPK;
import br.com.gabriel.repository.CourseRepository;
import br.com.gabriel.repository.StudentRepository;
import br.com.gabriel.repository.SubjectDetailRepository;
import br.com.gabriel.repository.SubjectRepository;
import br.com.gabriel.repository.TeacherRepository;
import br.com.gabriel.repository.TeamDetailRepository;
import br.com.gabriel.repository.TeamRepository;

@SpringBootApplication
public class SprintEvaluationApplication implements CommandLineRunner {

	@Autowired
	private CourseRepository courseRepository;
	@Autowired
	private SubjectRepository subjectRepository;
	@Autowired
	private SubjectDetailRepository subjectDetailRepository;
	@Autowired
	private StudentRepository studentRepository;
	@Autowired
	private TeacherRepository teacherRepository;
	@Autowired
	private TeamRepository teamRepository;
	@Autowired
	private TeamDetailRepository teamDetailRepository;

	public static void main(String[] args) {
		SpringApplication.run(SprintEvaluationApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		var course = new Course();
		course.setName("Técnologo de Segurança da Informação");
		var subject = new Subject();
		subject.setName("Raciocinio Algoritmico");
		var subject2 = new Subject();
		subject2.setName("É isso aí");

		var student = new Student();
		student.setName("Gabriel");
		student.setGender("M");
		student.setRegistration("123456");
		student.setBirthdate(LocalDate.now());

		var teacher = new Teacher();
		teacher.setName("João");
		teacher.setRegister("654321");
		teacher.setGender("M");

		var team = new Team();
		team.setName("Cibersegurança 1");

		var teamDetailPK = new TeamDetailPK();
		teamDetailPK.setStudent(student);
		teamDetailPK.setTeacher(teacher);
		teamDetailPK.setTeam(team);

		var teamDetail = new TeamDetail();
		teamDetail.setTeamDetailPK(teamDetailPK);

		var subjectDetailPK = new SubjectDetailPK();
		subjectDetailPK.setCourse(course);
		subjectDetailPK.setSubject(subject);

		var subjectDetail = new SubjectDetail();
		subjectDetail.setSubjectDetailPK(subjectDetailPK);

		courseRepository.save(course);
		subjectRepository.saveAll(Arrays.asList(subject, subject2));
		subjectDetailRepository.save(subjectDetail);

		studentRepository.save(student);
		teacherRepository.save(teacher);
		teamRepository.save(team);
		teamDetailRepository.save(teamDetail);

	}

}
