package com.lmstudio.component.javase;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class IdenCodeServlet
 */
public class IdenCodeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	static int WIDTH = 70;
	static int HEIGHT = 30;

	/**
	 * Constructor of the object.
	 */
	public IdenCodeServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("-------------doGet method invoked");
		doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to
	 * post.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse resp)
			throws ServletException, IOException {

		System.out.println("-------------doPost method invoked");
		
		BufferedImage buffImg = new BufferedImage(WIDTH, HEIGHT,
				BufferedImage.TYPE_INT_RGB);
		Graphics2D g = buffImg.createGraphics();

		// set background-color
		g.setBackground(Color.WHITE);
		g.fillRect(0, 0, WIDTH, HEIGHT);

		// set border
		g.setColor(Color.BLUE);
		g.drawRect(1, 1, WIDTH - 2, HEIGHT - 2);

		// set randline
		g.setColor(Color.BLACK);
		for (int i = 0; i < 4; i++) {
			int x1 = new Random().nextInt(WIDTH - 1);
			int y1 = new Random().nextInt(HEIGHT - 1);
			int x2 = new Random().nextInt(WIDTH - 1);
			int y2 = new Random().nextInt(HEIGHT - 1);
			g.drawLine(x1, y1, x2, y2);
		}

		// set randnum
		StringBuffer randnum = new StringBuffer();// for storage randnum
		g.setColor(Color.RED);
		Font font = new Font("宋体", Font.BOLD, 20);
		g.setFont(font);
		int b = 10;
		String str = "abcdefghijklmnopqrstuvwxysABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		for (int i = 0; i < 5; i++) {
			int id = new Random().nextInt(str.length());
			char c = str.toCharArray()[id];
			g.drawString(c + "", b, 20);
			b = b + 12;
			randnum.append(c+"");
		}
		System.out.println("-------"+randnum.toString());
		
		g.dispose(); 
        resp.setHeader("Pragma", "no-cache"); 
        resp.setHeader("Cache-Control", "no-cache"); 
        resp.setDateHeader("Expires", 0); 
        resp.setContentType("image/jpeg"); 
        ServletOutputStream sos = resp.getOutputStream(); 
        ImageIO.write(buffImg, "jpeg", sos); 
        sos.flush(); 
        sos.close();

	}

	/**
	 * Initialization of the servlet. <br>
	 * 
	 * @throws ServletException
	 *             if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
