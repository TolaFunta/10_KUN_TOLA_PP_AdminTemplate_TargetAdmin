package org.kshrd.template.repositories;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;
import org.kshrd.template.model.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository {
	/**
	 * Select a user from database
	 * 
	 * @param user
	 * @return
	 */
	@Select("SELECT count(gender) "
			+ "FROM users "
			+ "WHERE gender LIKE #{gender}")
	public long countTotal(@Param("gender") String gender);
	
	/**
	 * Select a user from database
	 * 
	 * @param user
	 * @return
	 */
	@Select("SELECT id, username, email, gender, phonenumber, status, created_date FROM users "
			+ "WHERE user_hash=#{user_hash}")
	public User findByUser_Hash(@Param("user_hash") String user_hash);
	
	/**
	 * Select all users from database
	 * 
	 * @param user
	 * @return
	 */
	@Select("SELECT id, username, email, gender, phonenumber, status, user_hash, created_date FROM users "
			+ "ORDER BY id DESC")
	public List<User> findAll();

	/**
	 * Save user to database
	 * 
	 * @param user
	 * @return
	 */
	@Insert("INSERT INTO users (username, email, gender, phonenumber, status, user_hash, created_date) "
			+ "VALUES (#{user.username}, #{user.email}, #{user.gender}, #{user.phonenumber}, #{user.status}, #{user.user_hash}, #{user.created_date})")
	@SelectKey(statement = "SELECT last_value FROM users_id_seq", keyProperty = "user.id", keyColumn = "last_value", before = false, resultType = int.class)
	public boolean save(@Param("user") User user);
	
	/**
	 * Delete user to database
	 * 
	 * @param user
	 * @return
	 */
	@Delete("DELETE FROM users "
			+ "WHERE user_hash=#{user_hash}")
	public boolean delete(@Param("user_hash") String user_Hash);
	
	/**
	 * Update user to database
	 * 
	 * @param user
	 * @return
	 */
	@Update("UPDATE users SET username=#{user.username}, email=#{user.email}, gender=#{user.gender}, phonenumber=#{user.phonenumber}, status=#{user.status}  "
			+ "WHERE user_hash=#{user.user_hash}")
	public boolean update(@Param("user") User user);

	/**
	 * Save batch user to database
	 * 
	 * @param user
	 * @return
	 */
	@Insert("<script>" + "	INSERT INTO users (" + "		username, " + "		email, " + "		password, "
			+ "		gender" + "	) VALUES " + " <foreach collection='users' item='user' separator=','>("
			+ "	#{user.username}," + "	#{user.email}," + "	#{user.password}," + "	#{user.gender}" + "	) "
			+ "</foreach>" + "</script>")
	public boolean saveBatch(@Param("users") List<User> users);

}
