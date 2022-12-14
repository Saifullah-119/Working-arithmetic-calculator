import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
class CalReal implements ActionListener
{
	//Begin variables
	int n1,n2;
	String x;
	JFrame frm;
	Container con;
	FlowLayout fly;
	JButton[] fbtn;
	BorderLayout bly;
	Panel pnl,pnl2;
	TextField txt1;
	TextField txt2;
	JButton[] btn;
	JLabel lbl;
	//End variables 
	
	//Begin constructor
	void runCal()
	{
		frm=new JFrame();
		con=frm.getContentPane();
		lbl=new JLabel("Test",JLabel.CENTER);
		lbl.setBackground(Color.decode("#b7b8cf"));
		lbl.setOpaque(true);
		lbl.setFont(new Font("Serif", Font.PLAIN, 60));

		
		fly = new FlowLayout();
		con.setLayout(fly);
		
		bly = new BorderLayout();
		con.setLayout(bly);
		
		pnl=new Panel();
		pnl.setLayout(new FlowLayout());
		
		
		txt1= new TextField("0");
		pnl.add(txt1);
		txt2= new TextField("0");
		pnl.add(txt2);
		pnl2=new Panel();
		pnl2.setLayout(new FlowLayout());
		btn=new JButton[5];
		btn[0]=new JButton("%");
		btn[1]=new JButton("+");
		btn[2]=new JButton("-");
		btn[3]=new JButton("*");
		btn[4]=new JButton("/");
		for(int i=0;i<btn.length;i++)
		{
			pnl2.add(btn[i]);
		}
		for(int i=0;i<btn.length;i++)
			btn[i].setPreferredSize(new Dimension(50, 50));
		for(int i=0;i<btn.length;i++)
			btn[i].addActionListener(this);
		con.add(pnl,BorderLayout.NORTH);
		con.add(pnl2,BorderLayout.CENTER);
		con.add(lbl,BorderLayout.SOUTH);
		
		frm.setSize(400,400);
		frm.setVisible(true);

		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	//End constructor
	public static void main(String args[])
	{
		CalReal c=new CalReal();
		c.runCal();
	}
	
	//Other Methods
	public void actionPerformed(ActionEvent e)
	{
		x=e.getActionCommand();
		int a=Integer.parseInt(txt1.getText());
		int b=Integer.parseInt(txt2.getText());
		if(x=="+")
			lbl.setText(a+b+"");
		if(x=="-")
			lbl.setText(a-b+"");
		if(x=="*")
			lbl.setText(a*b+"");
		if(x=="%")
			lbl.setText(a%b+"");
		if(x=="/")
		{
		if(b!=0)
			lbl.setText((a+0.0)/b+"");
		else
			lbl.setText("Math Error");
		}
	}
}