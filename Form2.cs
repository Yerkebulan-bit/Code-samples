using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Data.OleDb;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace FIS___Final_Project
{
    public partial class Form2 : Form
    {
        public Form2()
        {
            InitializeComponent();
        }

        private void Form2_Load(object sender, EventArgs e)
        {
            OleDbConnection conn = new OleDbConnection("Provider=Microsoft.ACE.OLEDB.12.0;Data Source=..\\Debug\\Database.accdb");
            OleDbCommand com = new OleDbCommand();
            OleDbDataAdapter adap = new OleDbDataAdapter();
            DataSet ds = new DataSet();
            DataTable dt = new DataTable();
            com.Connection = conn;
            com.CommandText = "SELECT ID, Date_of_publication, Requirement, Book_Name FROM Exchange WHERE Book_owner_ID = 1";
            conn.Open();
            adap.SelectCommand = com;
            adap.Fill(ds);
            dt = ds.Tables[0];
            dataGridView1.DataSource = dt;
            conn.Close();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            string date = DateTime.UtcNow.ToString("MM-dd-yyyy");
            OleDbConnection conn = new OleDbConnection("Provider=Microsoft.ACE.OLEDB.12.0;Data Source=..\\Debug\\Database.accdb");
            OleDbCommand com = new OleDbCommand();
            OleDbDataAdapter adap = new OleDbDataAdapter();
            DataSet ds = new DataSet();
            DataTable dt = new DataTable();
            conn.Open();
            OleDbCommand cmd = conn.CreateCommand();
            cmd.CommandType = CommandType.Text;
            cmd.CommandText = "INSERT INTO Exchange ([Date_of_publication],[Requirement],[Book_Name],[Book_owner_ID]) " +
                "VALUES('" + date + "','" + textBox2.Text + "', '" + textBox1.Text + "', '" + 1 + "')";
            cmd.ExecuteNonQuery();
            conn.Close();
            textBox1.Text = "";
            textBox2.Text = "";
            MessageBox.Show("An Item has been successfully added");
        }

        private void button2_Click(object sender, EventArgs e)
        {
            OleDbConnection conn = new OleDbConnection("Provider=Microsoft.ACE.OLEDB.12.0;Data Source=..\\Debug\\Database.accdb");
            OleDbCommand com = new OleDbCommand();
            OleDbDataAdapter adap = new OleDbDataAdapter();
            DataSet ds = new DataSet();
            DataTable dt = new DataTable();
            com.Connection = conn;
            com.CommandText = "SELECT ID, Date_of_publication, Requirement, Book_Name " +
                "FROM Exchange " +
                "WHERE Book_owner_ID = 1";
            conn.Open();
            adap.SelectCommand = com;
            adap.Fill(ds);
            dt = ds.Tables[0];
            dataGridView1.DataSource = dt;
            conn.Close();
        }

        private void button3_Click(object sender, EventArgs e)
        {
            OleDbConnection conn = new OleDbConnection("Provider=Microsoft.ACE.OLEDB.12.0;Data Source=..\\Debug\\Database.accdb");
            OleDbCommand com = new OleDbCommand();
            OleDbDataAdapter adap = new OleDbDataAdapter();
            DataSet ds = new DataSet();
            DataTable dt = new DataTable();
            conn.Open();
            OleDbCommand cmd = conn.CreateCommand();
            cmd.CommandType = CommandType.Text;
            cmd.CommandText = "DELETE FROM Exchange WHERE Book_Name='" + textBox3.Text + "'";
            cmd.ExecuteNonQuery();
            conn.Close();
            MessageBox.Show("Record deleted successfully");
        }
    }
}
