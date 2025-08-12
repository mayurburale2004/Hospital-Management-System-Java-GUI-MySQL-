create database hospital_management_system;
use hospital_management_system;


create table login(ID varchar(20), Pw varchar(20));
select * from login;
insert into login value("Mayur","123456");
insert into login value("pavan","1234");
CREATE TABLE patient_info (
    ID VARCHAR(20),
    Number VARCHAR(40),
    Name VARCHAR(20),
    Gender VARCHAR(20),
    Patient_Disease VARCHAR(20),
    Room_Number VARCHAR(20),
    Time varchar(50),
    Deposite VARCHAR(20)
);


CREATE TABLE Room (
    room_no VARCHAR(20) PRIMARY KEY,
    Availability VARCHAR(20),
    price DECIMAL(10, 2),
    Room_Type VARCHAR(100)
);
select * from patient_info;

select * from Room;
insert into Room values("100","Availabil","500","General Bed 1");
insert into Room values("101","Availabil","500","General Bed 2");
insert into Room values("102","Availabil","500","General Bed 3");
insert into Room values("103","Availabil","500","General Bed 4");
insert into Room values("104","Availabil","500","General Bed 5");
insert into Room values("105","Availabil","500","General Bed 6");
insert into Room values("106","Availabil","500","General Bed 7");
insert into Room values("200","Availabil","1500","Private Room");
insert into Room values("201","Availabil","1500","Private Room");
insert into Room values("202","Availabil","1500","Private Room");
insert into Room values("203","Availabil","1500","Private Room");
insert into Room values("204","Availabil","1500","Private Room");
insert into Room values("205","Availabil","1500","Private Room");
insert into Room values("206","Availabil","1500","Private Room");
insert into Room values("300","Availabil","3500","ICU Bed 1");
insert into Room values("301","Availabil","3500","ICU Bed 2");
insert into Room values("302","Availabil","3500","ICU Bed 3");
insert into Room values("303","Availabil","3500","ICU Bed 4");
insert into Room values("304","Availabil","3500","ICU Bed 5");
insert into Room values("305","Availabil","3500","ICU Bed 6");


create table Department(Department varchar(100), Phone_no varchar(20) PRIMARY KEY);
SELECT `Time` FROM patient_info;

select * from Department;
insert into Department values("Pediatric orthopedics ","1234567890");
insert into Department values("Trauma care","12345589");
insert into Department values("Orthopedic oncology ","12345639");
insert into Department values("Hand surgery ","123456779");
insert into Department values("Joint replacement surgery ","123456788");
INSERT INTO Department VALUES
('Cardiology', '9876543210'),
('Neurology', '8765432109'),
('Dermatology', '7654321098'),
('Ophthalmology', '6543210987'),
('ENT (Ear, Nose, Throat)', '5432109876'),
('Urology', '4321098765'),
('Pulmonology', '3210987654'),
('Gastroenterology', '2109876543'),
('Nephrology', '1098765432'),
('Endocrinology', '9988776655');
SELECT * FROM Department;

create table Employee(Name VARCHAR(20),Age VARCHAR(20), Phone_no varchar(20) PRIMARY KEY,Salary VARCHAR(20),Gmail VARCHAR(20),Aadhar_Number varchar(20) );
insert into Employee values("Doctor","30","552486248","10000001","pavan@gaail.com","24552162152");
INSERT INTO Employee VALUES
('Nurse', '28', '552486249', '500000', 'anita@gmail.com', '24552162153'),
('Surgeon', '35', '552486250', '1500000', 'rahul@gmail.com', '24552162154'),
('Pharmacist', '32', '552486251', '800000', 'priya@gmail.com', '24552162155'),
('Radiologist', '40', '552486252', '1200000', 'ajay@gmail.com', '24552162156'),
('Therapist', '29', '552486253', '600000', 'deepa@gmail.com', '24552162157'),
('Consultant', '45', '552486254', '2000000', 'vinay@gmail.com', '24552162158'),
('Pathologist', '38', '552486255', '1100000', 'meera@gmail.com', '24552162159'),
('Anesthesiologist', '41', '552486256', '1800000', 'karthik@gmail.com', '24552162160'),
('General Physician', '33', '552486257', '900000', 'lakshmi@gmail.com', '24552162161');
SELECT * FROM Employee;


create table Ambulance(Name varchar(20),Gender varchar(20),Car_name varchar(20),Available varchar(20),Location varchar(20));
insert into Ambulance values("av","Male","ZEN","Available","area 16");
INSERT INTO Ambulance VALUES 
('Amit', 'Male', 'ZEN', 'Available', 'Area 16'),
('Priya', 'Female', 'Honda', 'Available', 'Area 12'),
('Rahul', 'Male', 'Toyota', 'Not Available', 'Area 10'),
('Sita', 'Female', 'Ford', 'Available', 'Area 8'),
('Anil', 'Male', 'Hyundai', 'Not Available', 'Area 5'),
('Deepa', 'Female', 'Suzuki', 'Available', 'Area 14'),
('Arjun', 'Male', 'BMW', 'Available', 'Area 3'),
('Meera', 'Female', 'Kia', 'Not Available', 'Area 18'),
('Vikas', 'Male', 'Nissan', 'Available', 'Area 9'),
('Lakshmi', 'Female', 'Audi', 'Not Available', 'Area 7'),
('Karan', 'Male', 'Tesla', 'Available', 'Area 2');
select * from Ambulance;


CREATE TABLE discharged_patients (
    ID INT PRIMARY KEY AUTO_INCREMENT,
    Number VARCHAR(20),
    Name VARCHAR(50),
    Gender VARCHAR(10),
    Patient_Disease VARCHAR(50),
    Room_Number VARCHAR(10),
    In_Time TIMESTAMP,
    Out_Time TIMESTAMP,
    Deposit DECIMAL(10,2)
);
DESCRIBE discharged_patients;





