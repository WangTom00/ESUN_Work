CREATE TABLE Product (
    ProductID NVARCHAR(10) PRIMARY KEY,
    ProductName NVARCHAR(100),
    Price DECIMAL(10, 2),
    Quantity INT
);

INSERT INTO Product (ProductID, ProductName, Price, Quantity) VALUES
('P001', 'osii 舒壓按摩椅', 98000, 5),
('P002', '網友最愛起司蛋糕', 1200, 50),
('P003', '真愛密碼項鍊', 8500, 20);