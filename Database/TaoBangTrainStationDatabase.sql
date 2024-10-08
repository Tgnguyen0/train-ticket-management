﻿--Lenh tao table va thiet lap cac rang buoc--


Use TrainStationDatabase

EXEC sp_addtype 'GIOITINH', 'NVARCHAR(3)', 'NOT NULL';
EXEC sp_addtype 'LOAIVE', 'NVARCHAR(8)', 'NOT NULL';
EXEC sp_addtype 'LOAIGHE', 'NVARCHAR(14)', 'NOT NULL';
EXEC sp_addtype 'TRANGTHAIGHE', 'NVARCHAR(10)', 'NOT NULL';
EXEC sp_addtype 'DAINGO', 'FLOAT', 'NOT NULL';
EXEC sp_addtype 'TRANGTHAIGHE', 'INT', 'NOT NULL';

CREATE TABLE KhachHang (
    MaKH CHAR(12) NOT NULL PRIMARY KEY,
    TenKH NVARCHAR(100) NOT NULL,
    DiaChi NVARCHAR(100),
    SoDT NVARCHAR(24),
    DCMail NVARCHAR(50),
    GioiTinh GIOITINH CHECK (GioiTinh in ('Nam', 'Nữ'))
);

CREATE TABLE NhanVien (
    MaNV CHAR(6) NOT NULL PRIMARY KEY,
    TenNV NVARCHAR(100) NOT NULL,
	NgaySinh DATETIME CHECK (DATEDIFF(YEAR, NgaySinh, GETDATE()) >= 18),
    DiaChi NVARCHAR(100),
    SoDT NVARCHAR(24),
    GioiTinh GIOITINH CHECK (GioiTinh in ('Nam', 'Nữ'))
);

CREATE TABLE Tau (
	SoHieu NVARCHAR(6) NOT NULL PRIMARY KEY,
	SoToa INT CHECK (SoToa > 0),
	SoLuongToiDa INT DEFAULT 200,
)

CREATE TABLE Toa (
	MaToa NVARCHAR(6) NOT NULL PRIMARY KEY,
	TenToa NVARCHAR(12),
	SoLuongGhe INT CHECK (SoLuongGhe > 0),
	SoHieu NVARCHAR(6),
	FOREIGN KEY (SoHieu) REFERENCES Tau(SoHieu)
)

CREATE TABLE Ghe (
	MaGhe INT NOT NULL PRIMARY KEY,
	MaToa NVARCHAR(6) NOT NULL,
	LoaiGhe LOAIGHE CHECK (LoaiGhe in ('GheMem', 'Giuong4Tang', 'Giuong6Tang', 'Giuong2TangVip')),
	TrangThaiGhe TRANGTHAIGHE CHECK (TrangThaiGhe in ('gheCoNguoi', 'gheTrong')),
	FOREIGN KEY (MaToa) REFERENCES Toa(MaToa)
)

CREATE TABLE LichCapBenGa (
	MaLich NVARCHAR(6) NOT NULL PRIMARY KEY,
	SoHieu NVARCHAR(6),
	GioCapBen DATETIME,
	GioKhoiHanh DATETIME,
	CHECK (DATEDIFF(MINUTE, GioCapBen, GioKhoiHanh) > 0),
	MoTa NVARCHAR(100),
	FOREIGN KEY (SoHieu) REFERENCES Tau(SoHieu)
)

CREATE TABLE NhaGa (
	MaGa NVARCHAR(6) NOT NULL PRIMARY KEY,
	TenGa NVARCHAR(12),
	DiaChi NVARCHAR(100),
	SoDTLH NVARCHAR(24),
	ThanhPho NVARCHAR(20)
)

CREATE TABLE Ve (
    MaVe NVARCHAR(6) NOT NULL PRIMARY KEY,
    LoaiHang NVARCHAR(100) NOT NULL,
    NgayDatVe DATETIME CHECK (NgayDatVe >= GETDATE()),
    GiaVe FLOAT,
	MaKH CHAR(12) NOT NULL,
	DaiNgo DAINGO CHECK (DaiNgo IN (0, 0.05, 0.15, 0.25)),
    TenToa NVARCHAR(24),
    GaKhoiHanh NVARCHAR(50),
    GaKetThuc NVARCHAR(50),
	CHECK (GaKhoiHanh <> GaKetThuc),
    SoNgayHieuLucDoiVe INT DEFAULT 3
	FOREIGN KEY (MaKH) REFERENCES KhachHang(MaKH)
);

CREATE TABLE CT_HoaDon (
    MaChiTietHoaDon CHAR(12) NOT NULL PRIMARY KEY,
    MaVe NVARCHAR(6) NOT NULL,
	SoLuong INT NOT NULL CHECK (SoLuong > 0),
    TongTien FLOAT,
	Thue FLOAT,
	MaKH CHAR(12),
	FOREIGN KEY (MaVe) REFERENCES Ve(MaVe),
);

CREATE TABLE HoaDon (
    MaHD CHAR(12) NOT NULL PRIMARY KEY,
    NgayLap DATETIME DEFAULT GETDATE(),
	MaNV CHAR(6) NOT NULL,
    MaChiTietHoaDon CHAR(12),
	ThanhTien FLOAT,
	MaKH CHAR(12),
    GioiTinh char(12) CHECK (GioiTinh in ('Nam', 'Nữ'))
	FOREIGN KEY (MaNV) REFERENCES NhanVien(MaNV),
	FOREIGN KEY (MaKH) REFERENCES KhachHang(MaKH),
	FOREIGN KEY (MaChiTietHoaDon) REFERENCES CT_HoaDon(MaChiTietHoaDon)
);

--ALTER TABLE NhomSanPham
--ADD CONSTRAINT PK_NhomSanPham PRIMARY KEY (MaNhom);