package model.JobPost;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import util.DBManager;

public class JobPostDao {
    private Connection conn;
    private PreparedStatement pstmt;
    private ResultSet rs;

    private JobPostDao() {
    }

    private static JobPostDao instance = new JobPostDao();

    public static JobPostDao getInstance() {
        return instance;
    }

    public boolean createJobPost(JobPostDto dto) {
		boolean check = false;

		conn = DBManager.getConnection();
		if (conn != null) {
			String sql = "INSERT INTO job_posting_tb (corp_id, job_id, main_region_id, semi_region_id, recruit_people, recruit_period, salary, welfare, description) VALUES(?,?,?,?,?,?,?,?,?)";

			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, 0);
				pstmt.setInt(2, Integer.parseInt(dto.getJob()));
				pstmt.setInt(3, Integer.parseInt(dto.getRegion()));
				pstmt.setInt(4, Integer.parseInt(dto.getRegionDetail()));
				pstmt.setInt(5, Integer.parseInt(dto.getPeople()));
				pstmt.setString(6, dto.getPostDate());
				pstmt.setString(7, dto.getSalary());
				pstmt.setString(8, dto.getWelfare());
				pstmt.setString(9, dto.getJobDetail());

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

    public JobPostDto getJobPostbyId(String corp_id) {
        JobPostDto jobPostDto = null;
        conn = DBManager.getConnection();

        if (conn != null) {
            String sql = "SELECT * FROM job_posting_tb WHERE corp_id = ?";
            try {
                pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, corp_id);
                rs = pstmt.executeQuery();

                if (rs.next()) {
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

	/*
    public ArrayList<JobPostDto> getJobPostAll() {
        ArrayList<JobPostDto> list = new ArrayList<>();
        conn = DBManager.getConnection();

        if (conn != null) {
            String sql = "SELECT * FROM job_posting_tb";

            try {
                pstmt = conn.prepareStatement(sql);
                rs = pstmt.executeQuery();

                while (rs.next()) {
                    String id = rs.getString("corp_id");
                    String jobId = rs.getString("job_id");
                    String main_region_id = rs.getString("main_region_id");
                    String semi_region_id = rs.getString("semi_region_id");
                    int recruit_people = rs.getInt("recruit_people");
                    String recruit_period = rs.getString("recruit_period");
                    String salary = rs.getString("salary");
                    String welfare = rs.getString("welfare");
                    String description = rs.getString("description");

                    //JobPostDto jobPostDto = new JobPostDto(id, jobId, main_region_id, semi_region_id, recruit_people,
                            //recruit_period, salary, welfare, description);

                    //list.add(jobPostDto);
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                DBManager.close(conn, pstmt, rs);
            }
        }

        return list;
    }
	*/
}
