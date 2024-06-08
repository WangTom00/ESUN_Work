CREATE TABLE Product (
    ProductID NVARCHAR(10) PRIMARY KEY,
    ProductName NVARCHAR(100),
    Price DECIMAL(10, 2),
    Quantity INT
);

INSERT INTO Product (ProductID, ProductName, Price, Quantity) VALUES
('P001', 'osii ����������', 98000, 5),
('P002', '���ͳ̷R�_�q�J�|', 1200, 50),
('P003', '�u�R�K�X����', 8500, 20);