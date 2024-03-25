CREATE DATABASE QuanLiLuong


CREATE TABLE Kho(
	maKho nvarchar(20) NOT NULL primary key,
	diaChi nvarchar(100)
)

CREATE TABLE PhongBan(
	maPB nvarchar(20)  NOT NULL primary key,
	tenPB nvarchar(100)
)

CREATE TABLE NhanVien (
	maNV nvarchar(20) NOT NULL primary key,
	tenNV nvarchar(100),
	gioiTinh bit ,
	ngaySinh date,
	diaChi nvarchar(50) ,
	CMND nvarchar(12),
	chucVu nvarchar(20) ,
	trinhDoHocVan nvarchar(50) ,
	kinhNghiem nvarchar(50) ,
	heSoLuong float,
	phuCap float,
	anh nvarchar(100) ,
	phongBan nvarchar(20) FOREIGN KEY REFERENCES PhongBan(maPB),
	kho nvarchar(20) FOREIGN KEY REFERENCES Kho(maKho),
	
)

CREATE TABLE TaiKhoan (
	maTK nvarchar(20) NOT NULL primary key,
	tenTK nvarchar(100),
	matKhau nvarchar(100),
	nhanVien nvarchar (20) FOREIGN KEY REFERENCES NhanVien(maNV)
)



CREATE TABLE ChamCongNV(
	maChamCongNV nvarchar(30) NOT NULL primary key,
	ngayCN date,
	phep bit ,
	coMat bit ,
	soGioTangCa int ,
	trangThai bit ,
	ghiChu nvarchar(50) ,
	nhanVien nvarchar(20) FOREIGN KEY REFERENCES Nhanvien(maNV) 
)

CREATE TABLE SanPham(
	maSP nvarchar(20) NOT NULL primary key,
	tenSP nvarchar(100) ,
	donGia float,
	anh nvarchar(100) ,
	kho nvarchar(20) FOREIGN KEY REFERENCES Kho(maKho)
)

CREATE TABLE PhanCong (
	maPC nvarchar(20) NOT NULL primary key,
	ngayPC date,
	soLuong int, 
	congDoan nvarchar(50) ,
	sanPham nvarchar (20) FOREIGN KEY REFERENCES SanPham(maSP)
)

CREATE TABLE CongNhan (
	maCN nvarchar(20) NOT NULL primary key,
	tenCN nvarchar(100),
	gioiTinh bit ,
	ngaySinh date,
	diaChi nvarchar(50) ,
	CMND nvarchar(12),	
	phuCap float,
	anh nvarchar(100) ,
	nhanVien nvarchar(20)  FOREIGN KEY  REFERENCES NhanVien(maNV) ,
	phanCong nvarchar(20) FOREIGN KEY  REFERENCES PhanCong(maPC)
)

CREATE TABLE ChamCongCN(
	maChamCongCN nvarchar(20) NOT NULL primary key,
	ngayCN date,
	soSPHoanThanh nvarchar(50) ,
	soGioTangCa int ,
	trangThai bit , 
	congNhan nvarchar(20) FOREIGN KEY REFERENCES CongNhan(maCN)
)

CREATE TABLE TienLuong (
	maLuong nvarchar(20) NOT NULL primary key,
	mucLuong Int,
	chamCongCN nvarchar(20)  FOREIGN KEY REFERENCES ChamCongCN(maChamcongCN), 
	chamCongNV nvarchar(30) FOREIGN KEY  REFERENCES ChamCongNV(maChamcongNV)
)
SET DATEFORMAT DMY

INSERT PhongBan VALUES ('PB01',N'KẾ TOÁN')
INSERT TaiKhoan VALUES ('TK01','NGUYENVANLOC','LOCNGUYEN001')
INSERT NhanVien VALUES ('NV01','NGUYENVANLOC',0,'30/8/2002',	N'GÒ VẤP', '281391764',N'TRƯỞNG PHÒNG',N'ĐẠI HỌC','4 NĂM',2.92,500,'D:\','PB01',NULL)
INSERT NhanVien(maNV,tenNV) VALUES ('NV02','Cristiano Ronaldo')
INSERT NhanVien(maNV,tenNV,kho) VALUES ('NV03','Torres','K1')
delete from NhanVien where maNV ='NV03'
UPDATE NhanVien
SET phongBan = 'PB01'
WHERE maNV = 'NV02';

UPDATE NhanVien
SET kho = 'K1'
WHERE maNV = 'NV01';

UPDATE NhanVien
SET kho = 'K2'
WHERE maNV = 'NV02';

UPDATE Kho
SET diaChi = N'Gò Vấp'
WHERE maKho = 'K1';

INSERT Kho VALUES ('K1',N'GÒ VẤP')
INSERT Kho VALUES ('K2',N'Bình Thạnh')
INSERT SanPham (maSP,tenSP,kho) VALUES ('SP01',N'QUẦN TÂY', 'K1')
INSERT PhanCong(maPC,soLuong,congDoan,sanPham) VALUES ('PC02',1000,N'LÀ ỦI' ,'SP01')
INSERT PhanCong(maPC,soLuong,congDoan,sanPham) VALUES ('PC03',2000,N'LÀ ỦI' ,'SP01')
INSERT PhanCong(maPC,soLuong,congDoan,sanPham) VALUES ('PC04',2000,N'Rập máy' ,'SP01')
DELETE FROM PhanCong WHERE maPC='PC02'
DELETE FROM CongNhan WHERE maCN='CN03'

INSERT CongNhan(maCN,tenCN,phanCong) VALUES ('CN04','Hữu', 'PC04')
INSERT CongNhan(maCN,tenCN,phanCong) VALUES ('CN02','LONG', 'PC02')
INSERT CongNhan(maCN,tenCN,phanCong) VALUES ('CN03',N'TRỊNH', 'PC03')
INSERT ChamCongCN(maChamCongCN, congNhan) values('CC01', 'CN01')
INSERT ChamCongCN(maChamCongCN, congNhan) values('CC02', 'CN02')
INSERT ChamCongCN(maChamCongCN, congNhan) values('CC03', 'CN03')
SELECT * FROM NhanVien
SELECT * FROM ChamCongCN
SELECT * FROM CongNhan
SELECT * FROM PhanCong
DELETE FROM CongNhan WHERE maCN = 'CN01'
--Thêm công nhân
INSERT CongNhan(maCN,tenCN,gioiTinh,ngaySinh,CMND,diaChi,phuCap) VALUES ('CN01',N'Nguyễn Văn Lộc',0,GETDATE(),'281391764',N'301 Vưởn Lài- Gò Vấp', 500 )
INSERT CongNhan(maCN,tenCN,gioiTinh,ngaySinh,CMND,diaChi,phuCap) VALUES ('CN03',N'Nguyễn Thị Kim Ngân',1,GETDATE(),'281391764',N'Nguyễn Kiệm- Gò Vấp', 500 )
INSERT CongNhan(maCN,tenCN) VALUES ('CN02',N'Hữu')
INSERT CongNhan(maCN,tenCN,gioiTinh,ngaySinh,CMND,diaChi,phuCap,nhanVien) VALUES ('CN06',N'Nguyễn Thị Kim Ngân',1,GETDATE(),'281391764',N'Nguyễn Kiệm- Gò Vấp', 500,'NV01' )
INSERT CongNhan(maCN,tenCN,gioiTinh,ngaySinh,CMND,diaChi,phuCap,anh,nhanVien) VALUES ('CN07',N'Nguyễn Thị Kim Trâm',1,'22/7/2002','281391764',N'Nguyễn Kiệm- Gò Vấp', 1000,'T:\\HK5\\PTUD\\BTLonCK\\App_PayRoll\\src\\image\\add.png','NV01' )
INSERT CongNhan(maCN,tenCN,gioiTinh,ngaySinh,CMND,diaChi,phuCap,anh,nhanVien) VALUES ('CN09',N'Nguyễn Thị Kim Anh',1,'10/6/2002','281391764',N'Nguyễn Kiệm- Gò Vấp', 700,'T:\\HK5\\PTUD\\BTLonCK\\App_PayRoll\\src\\image\\add.png','NV02' )

SELECT maCN,tenCN,gioiTinh,ngaySinh,CMND,diaChi,phuCap,anh, nhanVien, phanCong
FROM CongNhan CN JOIN NhanVien NV ON 

SELECT CN.tenCN, PC.congDoan, CC.soSPhoanthanh, CC.soGioTangCa, CC.trangThai
FROM ChamCongCN CC JOIN CongNhan CN ON CC.congNhan =CN.maCN JOIN PhanCong PC ON PC.maPC= CN.phanCong
	WHERE  PC.congDoan LIKE N'LÀ ỦI'

SELECT CN.tenCN, PC.congDoan,CC.soSPHoanThanh,CC.soGioTangCa, CC.trangThai
FROM ChamCongCN CC JOIN CongNhan CN ON CC.congNhan =CN.maCN  JOIN PhanCong PC ON PC.maPC= CN.phanCong


SELECT CN.tenCN, PC.congDoan
FROM  CongNhan CN  JOIN PhanCong PC ON PC.maPC= CN.phanCong
WHERE CN.tenCN LIKE N'TRỊNH'


INSERT ChamCongNV(maChamCongNV, nhanVien) VALUES ('CCNV01', 'NV01')
SELECT NV.tenNV, CC.coMat, CC.trangThai, CC.phep,CC.soGioTangCa ,CC.ghiChu 
FROM ChamCongNV CC JOIN NhanVien NV ON CC.nhanVien =NV.MaNV 


UPDATE PhanCong SET ngayPC = ?, soLuong=? , congDoan=? 


delete from PhanCong where maPC = 'pc04'
select *from CongNhan

select *
from CongNhan cn Join NhanVien nv on cn.nhanVien= nv.maNV
where tenNV like N'%Cri%'


select *from SanPham where tenSP Like N'%Áo%'
