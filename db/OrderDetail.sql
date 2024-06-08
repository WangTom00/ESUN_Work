CREATE TABLE OrderDetail (
    OrderItemSN INT PRIMARY KEY IDENTITY(1,1),
    OrderID NVARCHAR(20),
    ProductID NVARCHAR(10),
    Quantity INT,
    StandPrice DECIMAL(10, 2),
    ItemPrice DECIMAL(10, 2),
    FOREIGN KEY (OrderID) REFERENCES [Order](OrderID),
    FOREIGN KEY (ProductID) REFERENCES Product(ProductID)
);

INSERT INTO OrderDetail (OrderID, ProductID, Quantity, StandPrice, ItemPrice) VALUES
('Ms20250801186230', 'P001', 1, 98000, 98000),
('Ms20250805157824', 'P002', 1, 1200, 1200),
('Ms20250805157824', 'P003', 1, 8500, 8500),
('Ms20250805258200', 'P002', 2, 1200, 2400);
