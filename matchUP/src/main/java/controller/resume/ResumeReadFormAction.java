//package controller.resume;
//
//import java.io.IOException;
//
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//
//import model.resume.Resume;
//import model.resume.ResumeDao;
//
//public class ResumeReadFormAction extends HttpServlet {
//    private static final long serialVersionUID = 1L;
//
//    protected void doGet(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        response.getWriter().append("Served at: ").append(request.getContextPath());
//    }
//
//    protected void doPost(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        request.setCharacterEncoding("UTF-8");
//        
//        System.out.println("ResumeReadFormAction doPost called");
//        
//        HttpSession session = request.getSession();
//        int puserIdx = (int) session.getAttribute("puserIdx");
//        
//        // 세션에 저장된 puserIdx를 콘솔에 출력
//        System.out.println("이력서 회원인덱스 확인용 : " + puserIdx);
//        
//        ResumeDao resumeDao = ResumeDao.getInstance();
//        Resume resume = resumeDao.getResumeInfo(puserIdx);
//
//        if (resume != null) {
//            int jobId = resume.getJobId();
//            String graduation = resume.getGraduation();
//            String degree = resume.getDegree();
//            String career = resume.getCareer();
//            String activity = resume.getActivity();
//            String certificate = resume.getCertificate();
//            String intro = resume.getIntro();
//                               
//            // 데이터를 request 속성에 저장
//            request.setAttribute("jobId", jobId);
//            request.setAttribute("graduation", graduation);
//            request.setAttribute("degree", degree);
//            request.setAttribute("career", career);
//            request.setAttribute("activity", activity);
//            request.setAttribute("certificate", certificate);
//            request.setAttribute("intro", intro);
//        } else {
//            System.out.println("이력서 정보가 없습니다."); // 이부분 추가
//        }
//
//        // JSP로 포워딩
//        String url = "resumeRead";
//        request.getRequestDispatcher(url).forward(request, response);
//    }      
//}