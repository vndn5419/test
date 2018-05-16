package GUI;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import DAO.ChickenDAO;
import DAO.EggDAO;
import VO.ChickenVO;
import VO.EggVO;

public class ChickenUI extends JFrame implements ActionListener {
	private JTextField kind_textField; // ǰ��
	private JTextField grade_textField; // ���
	private JTextField age_textField; // ����
	private JButton Enroll_Chicken_Button; // ġŲ��Ϲ�ư
	private JButton Delete_Chicken_Button; // ġŲ������ư
	private ChickenDAO dao; //ġŲDAO
	private EggDAO dao2;    //���DAO
	private JList chicken_list; // ġŲ����Ʈ
	private JTable Egg_table; // ��� ���̺�
	private JTextField egg_price_textField; //�������
	private JTextField egg_grade_textField; //������
	private JButton Delete_Egg_Button;//���������ư
	private JButton Enroll_Egg_Button;//����Ϲ�ư
	private String [] colName = new String[4];

	public ChickenUI() {
		dao = new ChickenDAO();
		dao2 = new EggDAO(	);
		
		colName[0] = "��Ϲ�ȣ";
		colName[1] = "ġŲ��ȣ";
		colName[2] = "����";
		colName[3] = "���";			
		
		setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\EclipseWorkSpace\\chicken_head.png"));
		setTitle("Chicken_House");

		setSize(500, 600);
		getContentPane().setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(24, 10, 189, 382);
		getContentPane().add(scrollPane);

		chicken_list = new JList();
		scrollPane.setViewportView(chicken_list);

		kind_textField = new JTextField();
		kind_textField.setBounds(87, 402, 116, 21);
		getContentPane().add(kind_textField);
		kind_textField.setColumns(10);

		grade_textField = new JTextField();
		grade_textField.setBounds(87, 433, 116, 21);
		getContentPane().add(grade_textField);
		grade_textField.setColumns(10);

		age_textField = new JTextField();
		age_textField.setBounds(87, 464, 116, 21);
		getContentPane().add(age_textField);
		age_textField.setColumns(10);

		JLabel lblNewLabel = new JLabel("\uD488\uC885");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(24, 405, 57, 15);
		getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("\uB4F1\uAE09");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(24, 436, 57, 15);
		getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("\uB098\uC774");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(24, 467, 57, 15);
		getContentPane().add(lblNewLabel_2);

		Enroll_Chicken_Button = new JButton("\uB4F1\uB85D");
		Enroll_Chicken_Button.setBounds(36, 507, 76, 23);
		Enroll_Chicken_Button.addActionListener(this);
		getContentPane().add(Enroll_Chicken_Button);

		Delete_Chicken_Button = new JButton("\uC0AD\uC81C");
		Delete_Chicken_Button.setBounds(124, 507, 76, 23);
		getContentPane().add(Delete_Chicken_Button);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(267, 10, 189, 382);
		getContentPane().add(scrollPane_1);
		
		Egg_table = new JTable();

		scrollPane_1.setViewportView(Egg_table);
		
		Enroll_Egg_Button = new JButton("\uB4F1\uB85D");
		Enroll_Egg_Button.setBounds(280, 507, 76, 23);
		getContentPane().add(Enroll_Egg_Button);
		Enroll_Egg_Button.addActionListener(this);
		
		egg_price_textField = new JTextField();
		egg_price_textField.setBounds(332, 405, 116, 21);
		getContentPane().add(egg_price_textField);
		egg_price_textField.setColumns(10);
		egg_price_textField.addActionListener(this);
		
		Delete_Egg_Button = new JButton("\uC0AD\uC81C");
		Delete_Egg_Button.setBounds(368, 507, 84, 23);
		getContentPane().add(Delete_Egg_Button);
		Delete_Egg_Button.addActionListener(this);
		
		egg_grade_textField = new JTextField();
		egg_grade_textField.setBounds(332, 436, 116, 21);
		getContentPane().add(egg_grade_textField);
		egg_grade_textField.setColumns(10);
		egg_grade_textField.addActionListener(this);
		
		JLabel lblNewLabel_3 = new JLabel("\uAC00\uACA9");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(267, 408, 57, 15);
		getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("\uB4F1\uAE09");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(267, 439, 57, 15);
		getContentPane().add(lblNewLabel_4);
		Delete_Chicken_Button.addActionListener(this);
		
		Egg_table.setVisible(true);
		refreshList();
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		// ġŲ��Ϲ�ư ����
		if (e.getSource() == Enroll_Chicken_Button) {
			String kind = kind_textField.getText(); // ǰ��
			String grade = grade_textField.getText(); // ���
			String age = age_textField.getText(); // ����

			ChickenVO vo = new ChickenVO();
			vo.setChicken_kind(kind);
			vo.setChicken_grade(grade);
			vo.setChicken_age(age);
			dao.insertChicken(vo);
			refreshList();
		}
		// ġŲ������ư ����
		else if (e.getSource() == Delete_Chicken_Button) {
			dao.deleteChicken((ChickenVO) chicken_list.getSelectedValue());
			refreshList();
		}   
		// �����Ϲ�ư ����
		else if(e.getSource() == Enroll_Egg_Button){
			EggVO vo = new EggVO();
			ChickenVO c= (ChickenVO) chicken_list.getSelectedValue();
			vo.setChicken_seq(c.getChicken_seq());
			
			String price = egg_price_textField.getText(); // ����
			String grade = egg_grade_textField.getText(); // ���
					
			vo.setEgg_price(price);
			vo.setEgg_grade(grade);
	
			dao2.insertEgg(vo);
			
		}
	}

	// DB������ JList ����
	public void refreshList() {
		// dao�� ���� ������ ġŲ����Ʋ �ܼ��迭�� �����Ͽ� list�� �����͸� ���ý�Ų��
		chicken_list.setListData(dao.chickenList().toArray());
	}

	public void refreshTable() {
		
	}
}
