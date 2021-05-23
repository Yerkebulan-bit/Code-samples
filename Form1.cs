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
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void Form1_Load(object sender, EventArgs e)
        {
            OleDbConnection conn = new OleDbConnection("Provider=Microsoft.ACE.OLEDB.12.0;Data Source=..\\Debug\\Database.accdb");
            OleDbCommand com = new OleDbCommand();
            OleDbDataAdapter adap = new OleDbDataAdapter();
            DataSet ds = new DataSet();
            DataTable dt = new DataTable();
            com.Connection = conn;
            com.CommandText = "SELECT Book.Name, Book.Genre, Book.Rating, Author.Name " +
                "FROM Book LEFT JOIN Author ON Author.ID = Book.Author_ID " +
                "Where Book.Name Like '%" + textBox1.Text + "%'" +
                "ORDER BY Book.Name";
            conn.Open();
            adap.SelectCommand = com;
            adap.Fill(ds);
            dt = ds.Tables[0];
            dataGridView1.DataSource = dt;
            conn.Close();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            OleDbConnection conn = new OleDbConnection("Provider=Microsoft.ACE.OLEDB.12.0;Data Source=..\\Debug\\Database.accdb"); 
            OleDbCommand com = new OleDbCommand();
            OleDbDataAdapter adap = new OleDbDataAdapter(); 
            DataSet ds = new DataSet(); 
            DataTable dt = new DataTable();
            com.Connection = conn; 
            com.CommandText = "SELECT Book.Name, Book.Genre, Book.Rating, Author.Name " +
                "FROM Book LEFT JOIN Author ON Author.ID = Book.Author_ID " +
                "Where Book.Name Like '%" + textBox1.Text + "%'" +
                "ORDER BY Book.Name";
            conn.Open();
            adap.SelectCommand = com; 
            adap.Fill(ds); 
            dt = ds.Tables[0]; 
            dataGridView1.DataSource = dt; 
            conn.Close();
        }

        private void button1_Click_1(object sender, EventArgs e)
        {
            Form2 newForm = new Form2();
            newForm.Show();
        }

        private void button2_Click(object sender, EventArgs e)
        {
            Form3 newForm = new Form3();
            newForm.Show();
        }

    }
}
