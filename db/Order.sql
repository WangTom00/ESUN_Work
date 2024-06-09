CREATE TABLE [Order] (
    OrderID NVARCHAR(20) PRIMARY KEY,
    MemberID INT,
    Price DECIMAL(10, 2),
    PayStatus BIT
);

INSERT INTO [Order] (OrderID, MemberID, Price, PayStatus) VALUES
('Ms20250801186230', 458, 98000, 1),
('Ms20250805157824', 55688, 9700, 0),
('Ms20250805258200', 1713, 2400, 1);


select * from Order