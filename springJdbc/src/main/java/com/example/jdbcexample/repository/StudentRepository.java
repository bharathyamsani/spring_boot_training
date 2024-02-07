package com.example.jdbcexample.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.example.jdbcexample.model.Student;

@Repository
public class StudentRepository {

	@Autowired
	private JdbcTemplate template;

	public String addStudent(Student s) {
		String sql = "insert into student (id, name, course) values(?,?,?)";
		int n = template.update(sql, s.getId(), s.getName(), s.getCourse());
		return n + " row/s added.";
	}

	public List<Student> getAllStudents() {
		String sql = "select * from Student;";

		RowMapper<Student> mapper = new RowMapper<Student>() {
			@Override
			public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
				Student s = new Student();
				s.setId(rs.getLong(1));
				s.setName(rs.getString(2));
				s.setCourse(rs.getString(3));
				return s;
			}
		};

		return template.query(sql, mapper);
	}

	public Student getStudent(long id) {
		String sql = "select * from Student where id=?;";
		ResultSetExtractor<Student> rse = new ResultSetExtractor<Student>() {
			public Student extractData(ResultSet rs) throws SQLException, DataAccessException {
				Student s = new Student();
				rs.next();
				s.setId(rs.getLong(1));
				s.setName(rs.getString(2));
				s.setCourse(rs.getString(3));
				return s;
			}
		};
		return template.query(sql, rse, id);
	}

	public String updateStudent(long id, Student s) {
		String sql = "update student set name=?,course=? where id=?";
		int n = template.update(sql, s.getName(), s.getCourse(), id);
		return n + " row/s updated";
	}

	public String deleteStudent(long id) {
		String sql = "delete from Student where id=?";
		int n = template.update(sql, id);
		return n + " row/s deleted";
	}

}
