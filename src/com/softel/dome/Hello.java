package com.softel.dome;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Hello {

	public static void main(String[] args) {
		try {
            // ��������,����sqlite��jdbc
            Class.forName("org.sqlite.JDBC");
            // �������ݿ�how2j.db,�����ֶ�����������
            Connection connection = DriverManager.getConnection("jdbc:sqlite:how2j.db");
            // �������Ӷ�����Java��һ���������ݿ����Ҫ�ӿ�
            Statement statement = connection.createStatement();
            // �ж��Ƿ��б�tables�Ĵ��ڡ�����ɾ��
            statement.executeUpdate("drop table if exists hero");
            // ������
            statement.executeUpdate("create table hero(id int,name varchar(20),hp int)");
            //��������
            statement.executeUpdate("insert into hero values(1,'Gareen','452')");
            // �������ݿ⣬�������ķ������ݼ�ResultSet��
            ResultSet rSet = statement.executeQuery("select * from hero");
            while (rSet.next()) { // ����������ݼ�
                System.out.println("id��" + rSet.getInt(1));
                System.out.println("������" + rSet.getString(2));
                System.out.println("Ѫ����" + rSet.getString(3));
            }
            rSet.close();// �ر����ݼ�
            connection.close();// �ر����ݿ�����
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
	}
}
