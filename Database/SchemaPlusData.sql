USE [master]
GO
/****** Object:  Database [Grammateia]    Script Date: 04-Sep-18 5:11:05 PM ******/
CREATE DATABASE [Grammateia]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'Grammateia', FILENAME = N'S:\Program Files\Microsoft SQL Server\MSSQL14.MSSQLSERVER\MSSQL\DATA\Grammateia.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'Grammateia_log', FILENAME = N'S:\Program Files\Microsoft SQL Server\MSSQL14.MSSQLSERVER\MSSQL\DATA\Grammateia_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
GO
ALTER DATABASE [Grammateia] SET COMPATIBILITY_LEVEL = 140
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [Grammateia].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [Grammateia] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [Grammateia] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [Grammateia] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [Grammateia] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [Grammateia] SET ARITHABORT OFF 
GO
ALTER DATABASE [Grammateia] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [Grammateia] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [Grammateia] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [Grammateia] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [Grammateia] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [Grammateia] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [Grammateia] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [Grammateia] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [Grammateia] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [Grammateia] SET  DISABLE_BROKER 
GO
ALTER DATABASE [Grammateia] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [Grammateia] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [Grammateia] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [Grammateia] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [Grammateia] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [Grammateia] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [Grammateia] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [Grammateia] SET RECOVERY FULL 
GO
ALTER DATABASE [Grammateia] SET  MULTI_USER 
GO
ALTER DATABASE [Grammateia] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [Grammateia] SET DB_CHAINING OFF 
GO
ALTER DATABASE [Grammateia] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [Grammateia] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [Grammateia] SET DELAYED_DURABILITY = DISABLED 
GO
EXEC sys.sp_db_vardecimal_storage_format N'Grammateia', N'ON'
GO
ALTER DATABASE [Grammateia] SET QUERY_STORE = OFF
GO
USE [Grammateia]
GO
ALTER DATABASE SCOPED CONFIGURATION SET IDENTITY_CACHE = ON;
GO
ALTER DATABASE SCOPED CONFIGURATION SET LEGACY_CARDINALITY_ESTIMATION = OFF;
GO
ALTER DATABASE SCOPED CONFIGURATION FOR SECONDARY SET LEGACY_CARDINALITY_ESTIMATION = PRIMARY;
GO
ALTER DATABASE SCOPED CONFIGURATION SET MAXDOP = 0;
GO
ALTER DATABASE SCOPED CONFIGURATION FOR SECONDARY SET MAXDOP = PRIMARY;
GO
ALTER DATABASE SCOPED CONFIGURATION SET PARAMETER_SNIFFING = ON;
GO
ALTER DATABASE SCOPED CONFIGURATION FOR SECONDARY SET PARAMETER_SNIFFING = PRIMARY;
GO
ALTER DATABASE SCOPED CONFIGURATION SET QUERY_OPTIMIZER_HOTFIXES = OFF;
GO
ALTER DATABASE SCOPED CONFIGURATION FOR SECONDARY SET QUERY_OPTIMIZER_HOTFIXES = PRIMARY;
GO
USE [Grammateia]
GO
/****** Object:  User [Grammateia]    Script Date: 04-Sep-18 5:11:05 PM ******/
CREATE USER [Grammateia] FOR LOGIN [Grammateia] WITH DEFAULT_SCHEMA=[dbo]
GO
ALTER ROLE [db_owner] ADD MEMBER [Grammateia]
GO
/****** Object:  Table [dbo].[Courses]    Script Date: 04-Sep-18 5:11:05 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Courses](
	[Courses_ID] [int] NOT NULL,
	[Courses_Name] [nvarchar](50) NOT NULL,
	[Course_Semester] [int] NOT NULL,
	[FK_Courses_Department_ID] [int] NOT NULL,
 CONSTRAINT [PK_Courses] PRIMARY KEY CLUSTERED 
(
	[Courses_ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Department]    Script Date: 04-Sep-18 5:11:05 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Department](
	[Department_ID] [int] IDENTITY(1,1) NOT NULL,
	[Department_name] [varchar](50) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[Department_ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Grades]    Script Date: 04-Sep-18 5:11:05 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Grades](
	[Grades_ID] [int] IDENTITY(1,1) NOT NULL,
	[Grades_Date] [datetime] NOT NULL,
	[Grades_Grade] [float] NOT NULL,
	[FK_Grades_Courses_ID] [int] NOT NULL,
 CONSTRAINT [PK_Grades] PRIMARY KEY CLUSTERED 
(
	[Grades_ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[GUser]    Script Date: 04-Sep-18 5:11:05 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[GUser](
	[GUser_ID] [int] IDENTITY(1,1) NOT NULL,
	[GUser_username] [varchar](50) NOT NULL,
	[GUser_password] [varchar](60) NOT NULL,
	[GUser_name] [varchar](50) NOT NULL,
	[GUser_surname] [varchar](50) NOT NULL,
	[GUser_department] [int] NOT NULL,
	[GUser_role] [varchar](50) NOT NULL,
 CONSTRAINT [PK__GUser__91FEE5ADBC97544D] PRIMARY KEY CLUSTERED 
(
	[GUser_ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Professors]    Script Date: 04-Sep-18 5:11:05 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Professors](
	[FK_Professors_GUser_ID] [int] NOT NULL,
	[Professors_email] [varchar](50) NOT NULL,
 CONSTRAINT [PK_Professors] PRIMARY KEY CLUSTERED 
(
	[FK_Professors_GUser_ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Professors_has_Courses]    Script Date: 04-Sep-18 5:11:05 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Professors_has_Courses](
	[Professors_has_Courses_ID] [int] IDENTITY(1,1) NOT NULL,
	[FK_Professors_has_Courses_Professors_ID] [int] NOT NULL,
	[FK_Professors_has_Courses_Courses_ID] [int] NOT NULL,
 CONSTRAINT [PK_Professors_has_Courses] PRIMARY KEY CLUSTERED 
(
	[Professors_has_Courses_ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Students]    Script Date: 04-Sep-18 5:11:05 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Students](
	[FK_Students_GUser_ID] [int] NOT NULL,
	[Students_Registration_Number] [varchar](50) NOT NULL,
	[Students_Gender] [varchar](50) NOT NULL,
	[Students_Semester] [int] NOT NULL,
 CONSTRAINT [PK_Students] PRIMARY KEY CLUSTERED 
(
	[FK_Students_GUser_ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Students_has_Courses]    Script Date: 04-Sep-18 5:11:06 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Students_has_Courses](
	[FK_Students_has_Courses_Students_ID] [int] NOT NULL,
	[FK_Students_has_Courses_Courses_ID] [int] NOT NULL,
	[Students_has_Courses_ID] [int] IDENTITY(1,1) NOT NULL,
 CONSTRAINT [PK_Students_has_Courses] PRIMARY KEY CLUSTERED 
(
	[Students_has_Courses_ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Students_has_Grades]    Script Date: 04-Sep-18 5:11:06 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Students_has_Grades](
	[FK_Students_has_Grades_GUser_ID] [int] NOT NULL,
	[FK_Students_has_Grades_Grades_ID] [int] NOT NULL,
	[Students_has_Grades_ID] [int] IDENTITY(1,1) NOT NULL,
 CONSTRAINT [PK_Students_has_Grades] PRIMARY KEY CLUSTERED 
(
	[Students_has_Grades_ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
INSERT [dbo].[Courses] ([Courses_ID], [Courses_Name], [Course_Semester], [FK_Courses_Department_ID]) VALUES (1, N'CS1', 1, 1)
INSERT [dbo].[Courses] ([Courses_ID], [Courses_Name], [Course_Semester], [FK_Courses_Department_ID]) VALUES (2, N'CS2', 1, 1)
INSERT [dbo].[Courses] ([Courses_ID], [Courses_Name], [Course_Semester], [FK_Courses_Department_ID]) VALUES (3, N'CS3', 1, 1)
INSERT [dbo].[Courses] ([Courses_ID], [Courses_Name], [Course_Semester], [FK_Courses_Department_ID]) VALUES (4, N'CS4', 2, 1)
INSERT [dbo].[Courses] ([Courses_ID], [Courses_Name], [Course_Semester], [FK_Courses_Department_ID]) VALUES (5, N'CS5', 3, 1)
INSERT [dbo].[Courses] ([Courses_ID], [Courses_Name], [Course_Semester], [FK_Courses_Department_ID]) VALUES (6, N'CS6', 4, 1)
INSERT [dbo].[Courses] ([Courses_ID], [Courses_Name], [Course_Semester], [FK_Courses_Department_ID]) VALUES (7, N'CS7', 5, 1)
INSERT [dbo].[Courses] ([Courses_ID], [Courses_Name], [Course_Semester], [FK_Courses_Department_ID]) VALUES (8, N'CS8', 6, 1)
INSERT [dbo].[Courses] ([Courses_ID], [Courses_Name], [Course_Semester], [FK_Courses_Department_ID]) VALUES (9, N'CS9', 7, 1)
INSERT [dbo].[Courses] ([Courses_ID], [Courses_Name], [Course_Semester], [FK_Courses_Department_ID]) VALUES (10, N'CS10', 8, 1)
INSERT [dbo].[Courses] ([Courses_ID], [Courses_Name], [Course_Semester], [FK_Courses_Department_ID]) VALUES (11, N'M1', 1, 2)
INSERT [dbo].[Courses] ([Courses_ID], [Courses_Name], [Course_Semester], [FK_Courses_Department_ID]) VALUES (12, N'M2', 2, 2)
INSERT [dbo].[Courses] ([Courses_ID], [Courses_Name], [Course_Semester], [FK_Courses_Department_ID]) VALUES (13, N'M3', 3, 2)
INSERT [dbo].[Courses] ([Courses_ID], [Courses_Name], [Course_Semester], [FK_Courses_Department_ID]) VALUES (14, N'M4', 4, 2)
INSERT [dbo].[Courses] ([Courses_ID], [Courses_Name], [Course_Semester], [FK_Courses_Department_ID]) VALUES (15, N'M5', 5, 2)
INSERT [dbo].[Courses] ([Courses_ID], [Courses_Name], [Course_Semester], [FK_Courses_Department_ID]) VALUES (16, N'M6', 6, 2)
INSERT [dbo].[Courses] ([Courses_ID], [Courses_Name], [Course_Semester], [FK_Courses_Department_ID]) VALUES (17, N'M7', 7, 2)
INSERT [dbo].[Courses] ([Courses_ID], [Courses_Name], [Course_Semester], [FK_Courses_Department_ID]) VALUES (18, N'M8', 8, 2)
SET IDENTITY_INSERT [dbo].[Department] ON 

INSERT [dbo].[Department] ([Department_ID], [Department_name]) VALUES (1, N'Computer Science')
INSERT [dbo].[Department] ([Department_ID], [Department_name]) VALUES (2, N'Mathematics')
SET IDENTITY_INSERT [dbo].[Department] OFF
SET IDENTITY_INSERT [dbo].[Grades] ON 

INSERT [dbo].[Grades] ([Grades_ID], [Grades_Date], [Grades_Grade], [FK_Grades_Courses_ID]) VALUES (4, CAST(N'2018-09-02T20:39:59.933' AS DateTime), 1, 1)
INSERT [dbo].[Grades] ([Grades_ID], [Grades_Date], [Grades_Grade], [FK_Grades_Courses_ID]) VALUES (11, CAST(N'2018-09-02T21:05:23.170' AS DateTime), 10, 6)
INSERT [dbo].[Grades] ([Grades_ID], [Grades_Date], [Grades_Grade], [FK_Grades_Courses_ID]) VALUES (13, CAST(N'2018-09-02T21:13:16.923' AS DateTime), 10, 2)
INSERT [dbo].[Grades] ([Grades_ID], [Grades_Date], [Grades_Grade], [FK_Grades_Courses_ID]) VALUES (14, CAST(N'2018-09-03T19:08:08.670' AS DateTime), 8, 9)
INSERT [dbo].[Grades] ([Grades_ID], [Grades_Date], [Grades_Grade], [FK_Grades_Courses_ID]) VALUES (15, CAST(N'2018-09-04T17:01:22.600' AS DateTime), 8, 17)
SET IDENTITY_INSERT [dbo].[Grades] OFF
SET IDENTITY_INSERT [dbo].[GUser] ON 

INSERT [dbo].[GUser] ([GUser_ID], [GUser_username], [GUser_password], [GUser_name], [GUser_surname], [GUser_department], [GUser_role]) VALUES (1, N'student', N'$2a$10$LBxz91A0c0nYU8xFsR/CmuWWkLdVwdaogqcybvgo9/RcNvzUOIwTS', N'student', N'student', 1, N'Student')
INSERT [dbo].[GUser] ([GUser_ID], [GUser_username], [GUser_password], [GUser_name], [GUser_surname], [GUser_department], [GUser_role]) VALUES (2, N'professor', N'$2a$10$KB6ttEs7r9JO8JelHQQ5GuPFM5/UIADpK743xdQA1xu2TH4UvJN7C', N'professor', N'professor', 1, N'Professor')
INSERT [dbo].[GUser] ([GUser_ID], [GUser_username], [GUser_password], [GUser_name], [GUser_surname], [GUser_department], [GUser_role]) VALUES (3, N'Gram', N'$2a$10$nVIgDPivFdQiHLk7//MggeKUdVobVdMJQbt.IDeEVaGXbUuXAKbgS', N'Gram', N'Gram', 1, N'Gram')
INSERT [dbo].[GUser] ([GUser_ID], [GUser_username], [GUser_password], [GUser_name], [GUser_surname], [GUser_department], [GUser_role]) VALUES (4, N'GNtina', N'$2a$10$N6VQe8ijYWIEw2Q6hs/wHOwDArODko1SdZx/qOsHsuS.6FYiOs.km', N'GNtina', N'GNtina', 2, N'Gram')
INSERT [dbo].[GUser] ([GUser_ID], [GUser_username], [GUser_password], [GUser_name], [GUser_surname], [GUser_department], [GUser_role]) VALUES (5, N'PNikos', N'$2a$10$AljS4I0bmXTVwNgxU1zANunkkkNdR/7GgEqFiW4bvu2Hyq6MsS2Xa', N'PNikos', N'PNikos', 1, N'Professor')
INSERT [dbo].[GUser] ([GUser_ID], [GUser_username], [GUser_password], [GUser_name], [GUser_surname], [GUser_department], [GUser_role]) VALUES (6, N'GNikos', N'$2a$10$Q5k8QvwilNk2.gf88q21BO3BZs1C6rTnrBz3.Cxooux/cdjvzzCBG', N'GNikos', N'GNikos', 1, N'Professor')
INSERT [dbo].[GUser] ([GUser_ID], [GUser_username], [GUser_password], [GUser_name], [GUser_surname], [GUser_department], [GUser_role]) VALUES (7, N'SGeorge', N'$2a$10$e5qlUQKPdl0vleabXCweROczaL52N.Y0IYhGXc/4sNbCwCzpO/OoO', N'SGeorge', N'SGeorge', 1, N'Student')
INSERT [dbo].[GUser] ([GUser_ID], [GUser_username], [GUser_password], [GUser_name], [GUser_surname], [GUser_department], [GUser_role]) VALUES (8, N'SLefteris', N'$2a$10$Efak0IkoTV/dLbV//AKPEuLV5VxPDjPVw1lmrzl0nGGJoJ7qeTNma', N'SLefteris', N'SLefteris', 2, N'Student')
INSERT [dbo].[GUser] ([GUser_ID], [GUser_username], [GUser_password], [GUser_name], [GUser_surname], [GUser_department], [GUser_role]) VALUES (9, N'Gram2', N'$2a$10$JA/gUs84u1r5FmP..gTR/OlEAIo8ch0l9I1mQvQmvJVx7HDukDOly', N'Gram2', N'Gram2', 2, N'Gram')
INSERT [dbo].[GUser] ([GUser_ID], [GUser_username], [GUser_password], [GUser_name], [GUser_surname], [GUser_department], [GUser_role]) VALUES (10, N'professor2', N'$2a$10$QON18pHpMT/Iu6hE9r.vy.r9S70748GcOxftFKU2u7JFMc.wjPqiu', N'professor2', N'professor2', 2, N'Professor')
INSERT [dbo].[GUser] ([GUser_ID], [GUser_username], [GUser_password], [GUser_name], [GUser_surname], [GUser_department], [GUser_role]) VALUES (11, N'student2', N'$2a$10$aP32widNwWj131mkiO8jW.mMx6Op7yBwkuJpE9NW.zWHfN6kpidre', N'student2', N'student2', 2, N'Student')
INSERT [dbo].[GUser] ([GUser_ID], [GUser_username], [GUser_password], [GUser_name], [GUser_surname], [GUser_department], [GUser_role]) VALUES (12, N'Gram3', N'$2a$10$fDZbYzcih4fN/NOItOLPEO.8wvKuLgT4OgHLLIAUFy0ncpBXO7BKC', N'Gram3', N'Gram3', 2, N'Gram')
INSERT [dbo].[GUser] ([GUser_ID], [GUser_username], [GUser_password], [GUser_name], [GUser_surname], [GUser_department], [GUser_role]) VALUES (13, N'professor3', N'$2a$10$a0ln1Ww5lBSsWWen/C64YOt/nzXQLxMp1l0shCVzHgExvxG0NcVry', N'professor3', N'professor3', 2, N'Professor')
INSERT [dbo].[GUser] ([GUser_ID], [GUser_username], [GUser_password], [GUser_name], [GUser_surname], [GUser_department], [GUser_role]) VALUES (14, N'student3', N'$2a$10$3QPOJudsgsi4CTFAK/mpuuQ0bBrebP7Ph/hJbak82TRAt4EHwZNRK', N'student3', N'student3', 1, N'Student')
SET IDENTITY_INSERT [dbo].[GUser] OFF
INSERT [dbo].[Professors] ([FK_Professors_GUser_ID], [Professors_email]) VALUES (2, N'professor')
INSERT [dbo].[Professors] ([FK_Professors_GUser_ID], [Professors_email]) VALUES (5, N'PNikos')
INSERT [dbo].[Professors] ([FK_Professors_GUser_ID], [Professors_email]) VALUES (6, N'GNikos')
INSERT [dbo].[Professors] ([FK_Professors_GUser_ID], [Professors_email]) VALUES (10, N'professor2')
INSERT [dbo].[Professors] ([FK_Professors_GUser_ID], [Professors_email]) VALUES (13, N'professor3')
SET IDENTITY_INSERT [dbo].[Professors_has_Courses] ON 

INSERT [dbo].[Professors_has_Courses] ([Professors_has_Courses_ID], [FK_Professors_has_Courses_Professors_ID], [FK_Professors_has_Courses_Courses_ID]) VALUES (1, 2, 1)
INSERT [dbo].[Professors_has_Courses] ([Professors_has_Courses_ID], [FK_Professors_has_Courses_Professors_ID], [FK_Professors_has_Courses_Courses_ID]) VALUES (2, 2, 2)
INSERT [dbo].[Professors_has_Courses] ([Professors_has_Courses_ID], [FK_Professors_has_Courses_Professors_ID], [FK_Professors_has_Courses_Courses_ID]) VALUES (3, 2, 3)
INSERT [dbo].[Professors_has_Courses] ([Professors_has_Courses_ID], [FK_Professors_has_Courses_Professors_ID], [FK_Professors_has_Courses_Courses_ID]) VALUES (4, 2, 4)
INSERT [dbo].[Professors_has_Courses] ([Professors_has_Courses_ID], [FK_Professors_has_Courses_Professors_ID], [FK_Professors_has_Courses_Courses_ID]) VALUES (5, 2, 5)
INSERT [dbo].[Professors_has_Courses] ([Professors_has_Courses_ID], [FK_Professors_has_Courses_Professors_ID], [FK_Professors_has_Courses_Courses_ID]) VALUES (6, 2, 6)
INSERT [dbo].[Professors_has_Courses] ([Professors_has_Courses_ID], [FK_Professors_has_Courses_Professors_ID], [FK_Professors_has_Courses_Courses_ID]) VALUES (7, 2, 8)
INSERT [dbo].[Professors_has_Courses] ([Professors_has_Courses_ID], [FK_Professors_has_Courses_Professors_ID], [FK_Professors_has_Courses_Courses_ID]) VALUES (8, 2, 9)
INSERT [dbo].[Professors_has_Courses] ([Professors_has_Courses_ID], [FK_Professors_has_Courses_Professors_ID], [FK_Professors_has_Courses_Courses_ID]) VALUES (9, 10, 11)
INSERT [dbo].[Professors_has_Courses] ([Professors_has_Courses_ID], [FK_Professors_has_Courses_Professors_ID], [FK_Professors_has_Courses_Courses_ID]) VALUES (10, 10, 17)
INSERT [dbo].[Professors_has_Courses] ([Professors_has_Courses_ID], [FK_Professors_has_Courses_Professors_ID], [FK_Professors_has_Courses_Courses_ID]) VALUES (11, 5, 10)
SET IDENTITY_INSERT [dbo].[Professors_has_Courses] OFF
INSERT [dbo].[Students] ([FK_Students_GUser_ID], [Students_Registration_Number], [Students_Gender], [Students_Semester]) VALUES (1, N'student', N'Female', 1)
INSERT [dbo].[Students] ([FK_Students_GUser_ID], [Students_Registration_Number], [Students_Gender], [Students_Semester]) VALUES (7, N'SGeorge', N'Male', 1)
INSERT [dbo].[Students] ([FK_Students_GUser_ID], [Students_Registration_Number], [Students_Gender], [Students_Semester]) VALUES (8, N'SLefteris', N'Male', 5)
INSERT [dbo].[Students] ([FK_Students_GUser_ID], [Students_Registration_Number], [Students_Gender], [Students_Semester]) VALUES (11, N'student2', N'Female', 1)
INSERT [dbo].[Students] ([FK_Students_GUser_ID], [Students_Registration_Number], [Students_Gender], [Students_Semester]) VALUES (14, N'student3', N'Male', 4)
SET IDENTITY_INSERT [dbo].[Students_has_Courses] ON 

INSERT [dbo].[Students_has_Courses] ([FK_Students_has_Courses_Students_ID], [FK_Students_has_Courses_Courses_ID], [Students_has_Courses_ID]) VALUES (1, 1, 1)
INSERT [dbo].[Students_has_Courses] ([FK_Students_has_Courses_Students_ID], [FK_Students_has_Courses_Courses_ID], [Students_has_Courses_ID]) VALUES (1, 3, 2)
INSERT [dbo].[Students_has_Courses] ([FK_Students_has_Courses_Students_ID], [FK_Students_has_Courses_Courses_ID], [Students_has_Courses_ID]) VALUES (1, 10, 3)
INSERT [dbo].[Students_has_Courses] ([FK_Students_has_Courses_Students_ID], [FK_Students_has_Courses_Courses_ID], [Students_has_Courses_ID]) VALUES (1, 4, 4)
SET IDENTITY_INSERT [dbo].[Students_has_Courses] OFF
SET IDENTITY_INSERT [dbo].[Students_has_Grades] ON 

INSERT [dbo].[Students_has_Grades] ([FK_Students_has_Grades_GUser_ID], [FK_Students_has_Grades_Grades_ID], [Students_has_Grades_ID]) VALUES (1, 4, 1)
INSERT [dbo].[Students_has_Grades] ([FK_Students_has_Grades_GUser_ID], [FK_Students_has_Grades_Grades_ID], [Students_has_Grades_ID]) VALUES (1, 11, 2)
INSERT [dbo].[Students_has_Grades] ([FK_Students_has_Grades_GUser_ID], [FK_Students_has_Grades_Grades_ID], [Students_has_Grades_ID]) VALUES (1, 13, 3)
INSERT [dbo].[Students_has_Grades] ([FK_Students_has_Grades_GUser_ID], [FK_Students_has_Grades_Grades_ID], [Students_has_Grades_ID]) VALUES (1, 14, 4)
INSERT [dbo].[Students_has_Grades] ([FK_Students_has_Grades_GUser_ID], [FK_Students_has_Grades_Grades_ID], [Students_has_Grades_ID]) VALUES (8, 15, 5)
SET IDENTITY_INSERT [dbo].[Students_has_Grades] OFF
SET ANSI_PADDING ON
GO
/****** Object:  Index [UQ__Departme__5707C3CF2C1C0451]    Script Date: 04-Sep-18 5:11:06 PM ******/
ALTER TABLE [dbo].[Department] ADD UNIQUE NONCLUSTERED 
(
	[Department_name] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
SET ANSI_PADDING ON
GO
/****** Object:  Index [UQ__GUser__C39E727B310DA462]    Script Date: 04-Sep-18 5:11:06 PM ******/
ALTER TABLE [dbo].[GUser] ADD  CONSTRAINT [UQ__GUser__C39E727B310DA462] UNIQUE NONCLUSTERED 
(
	[GUser_username] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
SET ANSI_PADDING ON
GO
/****** Object:  Index [IX_GUser_username_unique]    Script Date: 04-Sep-18 5:11:06 PM ******/
CREATE UNIQUE NONCLUSTERED INDEX [IX_GUser_username_unique] ON [dbo].[GUser]
(
	[GUser_username] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, DROP_EXISTING = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
SET ANSI_PADDING ON
GO
/****** Object:  Index [IX_Students_Registration_Number]    Script Date: 04-Sep-18 5:11:06 PM ******/
CREATE UNIQUE NONCLUSTERED INDEX [IX_Students_Registration_Number] ON [dbo].[Students]
(
	[Students_Registration_Number] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, DROP_EXISTING = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
ALTER TABLE [dbo].[Grades] ADD  CONSTRAINT [DF_Grades_Grades_Date]  DEFAULT (getdate()) FOR [Grades_Date]
GO
ALTER TABLE [dbo].[Students] ADD  CONSTRAINT [DF_Students_Students_Semester]  DEFAULT ((1)) FOR [Students_Semester]
GO
ALTER TABLE [dbo].[Courses]  WITH CHECK ADD  CONSTRAINT [FK_Courses_Department_ID] FOREIGN KEY([FK_Courses_Department_ID])
REFERENCES [dbo].[Department] ([Department_ID])
GO
ALTER TABLE [dbo].[Courses] CHECK CONSTRAINT [FK_Courses_Department_ID]
GO
ALTER TABLE [dbo].[Grades]  WITH CHECK ADD  CONSTRAINT [FK_Grades_Courses_ID] FOREIGN KEY([FK_Grades_Courses_ID])
REFERENCES [dbo].[Courses] ([Courses_ID])
GO
ALTER TABLE [dbo].[Grades] CHECK CONSTRAINT [FK_Grades_Courses_ID]
GO
ALTER TABLE [dbo].[GUser]  WITH CHECK ADD  CONSTRAINT [FK__GUser__GUser_dep__4AB81AF0] FOREIGN KEY([GUser_department])
REFERENCES [dbo].[Department] ([Department_ID])
GO
ALTER TABLE [dbo].[GUser] CHECK CONSTRAINT [FK__GUser__GUser_dep__4AB81AF0]
GO
ALTER TABLE [dbo].[Professors]  WITH CHECK ADD  CONSTRAINT [FK_Professors_GUser] FOREIGN KEY([FK_Professors_GUser_ID])
REFERENCES [dbo].[GUser] ([GUser_ID])
GO
ALTER TABLE [dbo].[Professors] CHECK CONSTRAINT [FK_Professors_GUser]
GO
ALTER TABLE [dbo].[Professors_has_Courses]  WITH CHECK ADD  CONSTRAINT [FK_Professors_has_Courses_Courses_ID] FOREIGN KEY([FK_Professors_has_Courses_Courses_ID])
REFERENCES [dbo].[Courses] ([Courses_ID])
GO
ALTER TABLE [dbo].[Professors_has_Courses] CHECK CONSTRAINT [FK_Professors_has_Courses_Courses_ID]
GO
ALTER TABLE [dbo].[Professors_has_Courses]  WITH CHECK ADD  CONSTRAINT [FK_Professors_has_Courses_Professors_ID] FOREIGN KEY([FK_Professors_has_Courses_Professors_ID])
REFERENCES [dbo].[Professors] ([FK_Professors_GUser_ID])
GO
ALTER TABLE [dbo].[Professors_has_Courses] CHECK CONSTRAINT [FK_Professors_has_Courses_Professors_ID]
GO
ALTER TABLE [dbo].[Students]  WITH CHECK ADD  CONSTRAINT [FK_Students_GUser_ID] FOREIGN KEY([FK_Students_GUser_ID])
REFERENCES [dbo].[GUser] ([GUser_ID])
GO
ALTER TABLE [dbo].[Students] CHECK CONSTRAINT [FK_Students_GUser_ID]
GO
ALTER TABLE [dbo].[Students_has_Courses]  WITH CHECK ADD  CONSTRAINT [FK_Students_has_Courses_Courses_ID] FOREIGN KEY([FK_Students_has_Courses_Courses_ID])
REFERENCES [dbo].[Courses] ([Courses_ID])
GO
ALTER TABLE [dbo].[Students_has_Courses] CHECK CONSTRAINT [FK_Students_has_Courses_Courses_ID]
GO
ALTER TABLE [dbo].[Students_has_Courses]  WITH CHECK ADD  CONSTRAINT [FK_Students_has_Courses_Students_ID] FOREIGN KEY([FK_Students_has_Courses_Students_ID])
REFERENCES [dbo].[Students] ([FK_Students_GUser_ID])
GO
ALTER TABLE [dbo].[Students_has_Courses] CHECK CONSTRAINT [FK_Students_has_Courses_Students_ID]
GO
ALTER TABLE [dbo].[Students_has_Grades]  WITH CHECK ADD  CONSTRAINT [FK_Students_has_Grades_Grades_ID] FOREIGN KEY([FK_Students_has_Grades_Grades_ID])
REFERENCES [dbo].[Grades] ([Grades_ID])
GO
ALTER TABLE [dbo].[Students_has_Grades] CHECK CONSTRAINT [FK_Students_has_Grades_Grades_ID]
GO
ALTER TABLE [dbo].[Students_has_Grades]  WITH CHECK ADD  CONSTRAINT [FK_Students_has_Grades_GUser_ID] FOREIGN KEY([FK_Students_has_Grades_GUser_ID])
REFERENCES [dbo].[Students] ([FK_Students_GUser_ID])
GO
ALTER TABLE [dbo].[Students_has_Grades] CHECK CONSTRAINT [FK_Students_has_Grades_GUser_ID]
GO
/****** Object:  StoredProcedure [dbo].[CallGUser]    Script Date: 04-Sep-18 5:11:06 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
-- =============================================
-- Author:		Name
-- Create date: 
-- Description:	
-- =============================================
CREATE PROCEDURE [dbo].[CallGUser] 
	-- Add the parameters for the stored procedure here
	@GUser_username nvarchar(50) = NULL, 
	@GUser_password nvarchar(50) = NULL
AS
BEGIN
	-- SET NOCOUNT ON added to prevent extra result sets from
	-- interfering with SELECT statements.
	SET NOCOUNT ON;

    -- Insert statements for procedure here
	SELECT GUser_name, GUser_surname
	FROM GUser
	WHERE GUser_username = @GUser_username AND GUser_password = @GUser_password
END
GO
USE [master]
GO
ALTER DATABASE [Grammateia] SET  READ_WRITE 
GO
