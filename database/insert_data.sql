USE springmvc

SELECT * FROM dbo.tbl_user;
GO
SELECT * FROM dbo.tbl_role;
GO
SELECT * FROM dbo.tbl_user_role
GO

INSERT INTO dbo.tbl_user
        ( fullname ,
          password ,
          status ,
          username
        )
VALUES  ( 'Nguyễn Văn Dương' , -- fullname - varchar(255)
          '$2a$10$/RUbuT9KIqk6f8enaTQiLOXzhnUkiwEJRdtzdrMXXwU7dgnLKTCYG' , -- password - varchar(255)
          1 , -- status - int
          'admin'  -- username - varchar(255)
        ),

( 'Nguyễn Văn A' , -- fullname - varchar(255)
          '$2a$10$/RUbuT9KIqk6f8enaTQiLOXzhnUkiwEJRdtzdrMXXwU7dgnLKTCYG' , -- password - varchar(255)
          1 , -- status - int
          'nguyenvana'  -- username - varchar(255)
        ),
( 'Nguyễn Văn B' , -- fullname - varchar(255)
          '$2a$10$/RUbuT9KIqk6f8enaTQiLOXzhnUkiwEJRdtzdrMXXwU7dgnLKTCYG' , -- password - varchar(255)
          1 , -- status - int
          'nguyenvanb'  -- username - varchar(255)
        )
GO


INSERT INTO dbo.tbl_role
        ( code, name )
VALUES  ( 'ADMIN', -- code - varchar(255)
          'Admin'  -- name - varchar(255)
          ),

		( 'USER', -- code - varchar(255)
          'User'  -- name - varchar(255)
          )
GO

INSERT INTO dbo.tbl_user_role
        ( roleID, userID )
VALUES  ( 1, -- roleID - numeric
          1  -- userID - numeric
          ),

		( 2, -- roleID - numeric
          2  -- userID - numeric
          ),

		( 2, -- roleID - numeric
          3  -- userID - numeric
          )
GO

SELECT * FROM dbo.tbl_user AS u JOIN dbo.tbl_user_role AS ur ON u.id = ur.userID JOIN dbo.tbl_role AS r ON ur.roleID = r.id;
GO