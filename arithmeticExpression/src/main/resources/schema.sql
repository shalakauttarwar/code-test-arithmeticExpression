DROP TABLE IF EXISTS Arithmetic_Expression;
 
CREATE TABLE Arithmetic_Expression(
  id INT AUTO_INCREMENT PRIMARY KEY,
  expression VARCHAR(250) NOT NULL,
  solution VARCHAR(250) NOT NULL
);
