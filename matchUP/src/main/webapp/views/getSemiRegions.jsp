<%@page import="org.json.JSONArray"%>
<%@ page language="java" contentType="application/json; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="util.DBManager" %>

<%
String region = request.getParameter("region");

Connection conn = null;
PreparedStatement pstmt = null;
ResultSet rs = null;

try {
    conn = DBManager.getConnection();
    String sql = "SELECT semi_region FROM semi_region_tb WHERE main_region = ?";
    pstmt = conn.prepareStatement(sql);
    pstmt.setString(1, region);
    rs = pstmt.executeQuery();
    
    // JSON 배열 생성
    JSONArray jsonArray = new JSONArray();
    
    while (rs.next()) {
        String semiRegion = rs.getString("semi_region");
        jsonArray.add(semiRegion);
    }
    
    // JSON 배열 출력
    response.setContentType("application/json");
    response.setCharacterEncoding("UTF-8");
    response.getWriter().write(jsonArray.toJSONString());
} catch (Exception e) {
    e.printStackTrace();
    System.out.println("semi_region 데이터 연동 및 출력 실패");
} finally {
    try {
        if (rs != null) {
            rs.close();
        }
        if (pstmt != null) {
            pstmt.close();
        }
        if (conn != null) {
            conn.close();
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
}
%>