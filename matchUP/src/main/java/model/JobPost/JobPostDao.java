package model.JobPost;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import util.DBManager;

public class JobPostDao {
    private Connection conn;
    private PreparedStatement pstmt;
    private ResultSet rs;

    public JobPostDao() {
    }

    private static JobPostDao instance = new JobPostDao();

    public static JobPostDao getInstance() {
        return instance;
    }

    public boolean createJobPost(JobPostDto dto) {
		boolean check = false;

		conn = DBManager.getConnection();
		if (conn != null) {
			String sql = "INSERT INTO job_posting_tb (title, corp_name, staffs, ceo, job_id, main_region_id, semi_region_id, recruit_people, recruit_period, salary, welfare, description) VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";

			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, dto.getTitle());
				pstmt.setString(2, dto.getCorp_name());
				pstmt.setString(3, dto.getStaffs());				
				pstmt.setString(4, dto.getCeo());
				pstmt.setInt(5, Integer.parseInt(dto.getJob()));
				pstmt.setInt(6, Integer.parseInt(dto.getRegion()));
				pstmt.setInt(7, Integer.parseInt(dto.getRegionDetail()));
				pstmt.setInt(8, Integer.parseInt(dto.getPeople()));
				pstmt.setString(9, dto.getPostDate());
				pstmt.setString(10, dto.getSalary());
				pstmt.setString(11, dto.getWelfare());
				pstmt.setString(12, dto.getJobDetail());

				pstmt.execute();	
				check = true;
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				DBManager.close(conn, pstmt);
			}
		} 
		
        return check;
    }
/*
    public JobPostDto getJobPostbyId(String post_id) {
        JobPostDto jobPostDto = null;
        conn = DBManager.getConnection();

        if (conn != null) {
            String sql = "SELECT * FROM job_posting_tb WHERE post_id = ?";
            try {
                pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, post_id);
                rs = pstmt.executeQuery();

                if (rs.next()) {
                	String corp_name = rs.getString("corp_name");
                	int staffs = rs.getInt("staffs");
                	String ceo = rs.getString("ceo");
                    String jobId = rs.getString("job_id");
                    String main_region_id = rs.getString("main_region_id");
                    String semi_region_id = rs.getString("semi_region_id");
                    int recruit_people = rs.getInt("recruit_people");
                    String recruit_period = rs.getString("recruit_period");
                    String salary = rs.getString("salary");
                    String welfare = rs.getString("welfare");
                    String description = rs.getString("description");

                    //jobPostDto = new JobPostDto(corp_id, jobId, main_region_id, semi_region_id, recruit_people,
                            //recruit_period, salary, welfare, description);
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                DBManager.close(conn, pstmt, rs);
            }
        }

        return jobPostDto;
    }
    */
    public JobPostDto getJobPostbyId(int post_id) {
        JobPostDto jobPostDto = null;
        conn = DBManager.getConnection();

        if (conn != null) {
            String sql = "SELECT * FROM job_posting_tb WHERE post_id = ?";
            try {
                this.pstmt = conn.prepareStatement(sql);
                this.pstmt.setInt(1, post_id);
                this.rs = pstmt.executeQuery();

                if (this.rs.next()) {
                	String title = rs.getString("title");
                	String corp_name = rs.getString("corp_name");
                	String staffs = rs.getString("staffs");
                	String ceo = rs.getString("ceo");
                    String jobId = rs.getString("job_id");
                    String main_region_id = rs.getString("main_region_id");
                    String semi_region_id = rs.getString("semi_region_id");
                    String recruit_people = rs.getString("recruit_people");
                    String recruit_period = rs.getString("recruit_period");
                    String salary = rs.getString("salary");
                    String welfare = rs.getString("welfare");
                    String description = rs.getString("description");
    				Timestamp created_post = this.rs.getTimestamp(13);
    				String create_postToString = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss").format(created_post);
                    
                    
    				jobPostDto = new JobPostDto(post_id, title, corp_name, staffs, ceo, jobId, main_region_id, semi_region_id, recruit_people, recruit_period, salary, welfare, description, create_postToString);
                   
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                DBManager.close(conn, pstmt, rs);
            }
        }

        return jobPostDto;
    }

	public ArrayList<JobPostDto> getPostByCorpName(String corpName) {
		ArrayList<JobPostDto> list = new ArrayList<JobPostDto>();

	    // 리스트
	    Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = DBManager.getConnection();
            if (conn != null) {
                String sql = "SELECT * FROM job_posting_tb WHERE corp_name = ?";
                pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, corpName);
                rs = pstmt.executeQuery();

                if (rs.next()) {
                	int postId = this.rs.getInt(1);
                	String title = this.rs.getString(2);
    				String corp_name = this.rs.getString(3);
    				String staffs = this.rs.getString(4);
    				String ceo = this.rs.getString(5);
    				String job_id = this.rs.getInt(6) + "";
    				String main_region = this.rs.getInt(7) + "";
    				String semi_region = this.rs.getInt(8) + "";
    				String recruit_people = this.rs.getString(9);
    				String recruit_period = this.rs.getString(10);
    				String salary = this.rs.getString(11);
    				String welfare = this.rs.getString(12);
    				String desc = this.rs.getString(13);
    				Timestamp created_post = this.rs.getTimestamp(14);
    				String create_postToString = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss").format(created_post);

    				JobPostDto post = new JobPostDto(postId, title, corp_name, staffs, ceo, job_id, main_region, semi_region, recruit_people,recruit_period, salary, welfare, desc, create_postToString);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBManager.close(conn, pstmt, rs);
        }

        return list;
    }

}
