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
    public partial class Form3 : Form
    {
        public Form3()
        {
            InitializeComponent();
        }

        private void Form3_Load(object sender, EventArgs e)
        {
            OleDbConnection conn = new OleDbConnection("Provider=Microsoft.ACE.OLEDB.12.0;Data Source=..\\Debug\\Database.accdb");
            OleDbCommand com = new OleDbCommand();
            OleDbDataAdapter adap = new OleDbDataAdapter();
            DataSet ds = new DataSet();
            DataTable dt = new DataTable();
            com.Connection = conn;
            com.CommandText = "SELECT Library.Name, Library.Type, Library.Rating, Library.Location, City.Name"
            + " FROM Library LEFT JOIN City ON City.ID = Library.City_ID"
            + " Where Library.Name Like '%" + textBox1.Text + "%'";
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
            com.CommandText = "SELECT Library.Name, Library.Type, Library.Rating, City.Name"
            + " FROM Library LEFT JOIN City ON City.ID = Library.City_ID"
            + " Where Library.Name Like '%" + textBox1.Text + "%'";
            conn.Open();
            adap.SelectCommand = com;
            adap.Fill(ds);
            dt = ds.Tables[0];
            dataGridView1.DataSource = dt;
            conn.Close();
        }
    }
}

// com.CommandText = "SELECT Library.Name, Library.Type, Library.Rating, City.Name
// FROM Library LEFT JOIN City ON City.ID = Library.City ID
// Where Library.Name Like '%" + textBox1.Text + "%'";
    //com.CommandText = "SELECT Library.Name, Library.Type, Library.Rating " +
    //"FROM Library Where Library.Name Like '%" + textBox1.Text + "%'";