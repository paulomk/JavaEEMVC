package com.cestar.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.cestar.beans.TaxFiler;

public class TaxFilerDao {

 	private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public int saveTaxFiler(TaxFiler tf) {
        String query = "INSERT INTO TaxFilers (Name, Contact, AnnualIncome, Expenses, TaxYear) VALUES(?,?,?,?,?)";
        return jdbcTemplate.update(query, tf.getName(), tf.getContact(), tf.getAnnualIncome(),
        		tf.getExpenses(), tf.getTaxYear());
    }

    public int updateTaxFiler(TaxFiler tf) {
        String query = "UPDATE TaxFilers SET Name=?, Contact=?, AnnualIncome=?, Expenses=?, TaxYear=? WHERE FilerID=?";
        return jdbcTemplate.update(query, tf.getName(), tf.getContact(), tf.getAnnualIncome(),
        		tf.getExpenses(), tf.getTaxYear(), tf.getFilerID());
    }

    public int deleteTaxFiler(int tfId) {
        String query = "DELETE FROM TaxFilers WHERE FilerID=?";
        return jdbcTemplate.update(query, tfId);
    }

    public TaxFiler getTaxFilerById(int tfId) {
        String query = "SELECT * FROM TaxFilers WHERE FilerID=" + tfId;
        List<TaxFiler> tfs = jdbcTemplate.query(query, new RowMapper<TaxFiler>() {
            @Override
            public TaxFiler mapRow(ResultSet rs, int rowNum) throws SQLException {
            	TaxFiler tf = new TaxFiler();
                tf.setFilerID(rs.getInt("FilerID"));
                tf.setName(rs.getString("Name"));
                tf.setContact(rs.getString("Contact"));
                tf.setAnnualIncome(rs.getDouble("AnnualIncome"));
                tf.setExpenses(rs.getDouble("Expenses"));
                tf.setTaxYear(rs.getInt("TaxYear"));
                return tf;
            }
        });
        return tfs.isEmpty() ? null : tfs.get(0);
    }

    public List<TaxFiler> getAllTaxFilers() {
        String query = "SELECT * FROM TaxFilers";
        return jdbcTemplate.query(query, new RowMapper<TaxFiler>() {
            @Override
            public TaxFiler mapRow(ResultSet rs, int rowNum) throws SQLException {
            	TaxFiler tf = new TaxFiler();
                tf.setFilerID(rs.getInt("FilerID"));
                tf.setName(rs.getString("Name"));
                tf.setContact(rs.getString("Contact"));
                tf.setAnnualIncome(rs.getDouble("AnnualIncome"));
                tf.setExpenses(rs.getDouble("Expenses"));
                tf.setTaxYear(rs.getInt("TaxYear"));
                return tf;
            }
        });
    }
	
	
}
