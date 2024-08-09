DROP DATABASE IF EXISTS FilersRecord;
CREATE DATABASE FilersRecord;

USE FilersRecord;

DROP DATABASE IF EXISTS TaxFilers;
CREATE TABLE TaxFilers (
    FilerID INT AUTO_INCREMENT PRIMARY KEY,
    Name VARCHAR(100),
    Contact VARCHAR(15),
    AnnualIncome DECIMAL(15, 2),
    Expenses DECIMAL(15, 2),
    TaxYear INT
);

-- Insert sample records
INSERT INTO TaxFilers (Name, Contact, AnnualIncome, Expenses, TaxYear) VALUES
('Mary Smith', '11111111', 50000.00, 10000.00, 2020),
('Jake Johnson', '2222222', 60000.00, 12000.00, 2024),
('Jade Blake', '3333333', 70000.00, 15000.00, 2022),
('Emily Stewart', '444444444', 55000.00, 9000.00, 2022),
('Sam Silvers', '5555555555', 80000.00, 20000.00, 2020);

SELECT * FROM TaxFilers;