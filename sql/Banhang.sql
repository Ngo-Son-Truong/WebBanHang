USE [demojv5]
GO
/****** Object:  Table [dbo].[accounts]    Script Date: 25/07/2023 5:29:59 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[accounts](
	[username] [varchar](30) NOT NULL,
	[activated] [bit] NULL,
	[admin] [bit] NULL,
	[email] [varchar](150) NULL,
	[fullname] [nvarchar](70) NULL,
	[password] [varchar](30) NULL,
	[photo] [varchar](255) NULL,
PRIMARY KEY CLUSTERED 
(
	[username] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[cart_item]    Script Date: 25/07/2023 5:29:59 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[cart_item](
	[id] [bigint] IDENTITY(1,1) NOT NULL,
	[name] [varchar](255) NULL,
	[photo] [varchar](255) NULL,
	[price] [float] NOT NULL,
	[qty] [int] NOT NULL,
	[product_id_id] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[categories]    Script Date: 25/07/2023 5:29:59 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[categories](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[name] [varchar](255) NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[orderdetails]    Script Date: 25/07/2023 5:29:59 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[orderdetails](
	[id] [bigint] IDENTITY(1,1) NOT NULL,
	[price] [float] NULL,
	[quantity] [int] NULL,
	[orderid] [bigint] NULL,
	[productid] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[orders]    Script Date: 25/07/2023 5:29:59 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[orders](
	[id] [bigint] IDENTITY(1,1) NOT NULL,
	[address] [varchar](255) NULL,
	[createdate] [date] NULL,
	[username] [varchar](30) NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[products]    Script Date: 25/07/2023 5:29:59 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[products](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[available] [int] NOT NULL,
	[deadline] [datetime2](6) NULL,
	[description] [nvarchar](255) NULL,
	[image] [varchar](255) NULL,
	[name] [varchar](255) NULL,
	[price] [float] NOT NULL,
	[categoryid] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
INSERT [dbo].[accounts] ([username], [activated], [admin], [email], [fullname], [password], [photo]) VALUES (N'admin', 1, 1, N'admin@gmail.com', N'admin', N'123456', N'R.jfif')
INSERT [dbo].[accounts] ([username], [activated], [admin], [email], [fullname], [password], [photo]) VALUES (N'admin1', 1, 1, N'abc@gmail.com', N'nguyen van b', N'123456', N'1.jpg')
SET IDENTITY_INSERT [dbo].[cart_item] ON 

INSERT [dbo].[cart_item] ([id], [name], [photo], [price], [qty], [product_id_id]) VALUES (1, N'Mô Hình Ahri League Of Leagend', N'mo-hinh-ahri-lmht.png', 100, 1, 4)
SET IDENTITY_INSERT [dbo].[cart_item] OFF
SET IDENTITY_INSERT [dbo].[categories] ON 

INSERT [dbo].[categories] ([id], [name]) VALUES (1, N'League Of Leagend')
INSERT [dbo].[categories] ([id], [name]) VALUES (4, N'Genshin Impact')
INSERT [dbo].[categories] ([id], [name]) VALUES (5, N'Hololive')
INSERT [dbo].[categories] ([id], [name]) VALUES (6, N'HonKai Impact')
INSERT [dbo].[categories] ([id], [name]) VALUES (7, N'Anime')
INSERT [dbo].[categories] ([id], [name]) VALUES (8, N'Ngô Son Tru?ng')
SET IDENTITY_INSERT [dbo].[categories] OFF
SET IDENTITY_INSERT [dbo].[products] ON 

INSERT [dbo].[products] ([id], [available], [deadline], [description], [image], [name], [price], [categoryid]) VALUES (4, 10, CAST(N'2023-06-23 00:00:00.0000000' AS DateTime2), N'Mô Hình Ahri League Of Leagend Limited', N'mo-hinh-ahri-lmht.png', N'Mô Hình Ahri League Of Leagend', 100, 1)
INSERT [dbo].[products] ([id], [available], [deadline], [description], [image], [name], [price], [categoryid]) VALUES (6, 10, CAST(N'2023-06-23 00:00:00.0000000' AS DateTime2), N'Mô Hình Kayn League Of Leagend', N'mo-hinh-kayn-figure-lmht.png', N'Mô Hình Kayn League Of Leagend', 100, 1)
INSERT [dbo].[products] ([id], [available], [deadline], [description], [image], [name], [price], [categoryid]) VALUES (8, 10, CAST(N'2023-06-23 00:00:00.0000000' AS DateTime2), N'Mô Hình True Damage Akali League Of Leagend', N'mo-hinh-lol-akali-true-damage-figure-lmht-1-1-600x600.png', N'Mô Hình True Damage Akali League Of Leagend', 100, 1)
INSERT [dbo].[products] ([id], [available], [deadline], [description], [image], [name], [price], [categoryid]) VALUES (9, 100, CAST(N'2023-06-23 00:00:00.0000000' AS DateTime2), N'Mô Hình Ashe Siêu Phẩm League Of Leagend', N'mo-hinh-lol-ashe-sieu-pham-lmht-.png', N'Mô Hình Ashe Siêu Ph?m League Of Leagend', 100, 1)
INSERT [dbo].[products] ([id], [available], [deadline], [description], [image], [name], [price], [categoryid]) VALUES (10, 10, CAST(N'2023-06-23 00:00:00.0000000' AS DateTime2), N'Mô Hình Zoe Vệ Binh Tinh Tú League Of Leagend', N'mo-hinh-lol-zoe-ve-binh-tinh-tu-lmht-gsc.png', N'Mô Hình Zoe V? Binh Tinh Tú League Of Leagend', 100, 1)
INSERT [dbo].[products] ([id], [available], [deadline], [description], [image], [name], [price], [categoryid]) VALUES (11, 10, CAST(N'2023-06-23 00:00:00.0000000' AS DateTime2), N'Mô Hình Viego League Of Leagend', N'mo-hinh-viego-unlocked-lmht.png', N'Mô Hình Viego League Of Leagend', 100, 1)
INSERT [dbo].[products] ([id], [available], [deadline], [description], [image], [name], [price], [categoryid]) VALUES (12, 10, CAST(N'2023-06-23 00:00:00.0000000' AS DateTime2), N'Mô Hình Kiana HonKai Impact', N'arctech_posable_series_honkai_impact_3rd_kiana_void_drifter_ver.jpg', N'Mô Hình Kiana HonKai Impact', 100, 6)
INSERT [dbo].[products] ([id], [available], [deadline], [description], [image], [name], [price], [categoryid]) VALUES (13, 50, CAST(N'2023-06-23 00:00:00.0000000' AS DateTime2), N'Asteroid Series Honkai Impact 3rd Kiana Kaslana Neko Birthday', N'asteroid_series_houkai_3rd_kiana_kaslana_kikia_tenshi__2__08bed7bb7a34479f94898b303c136209_large.jpg', N'Asteroid Series Honkai Impact 3rd Kiana Kaslana Neko Birthday', 100, 6)
INSERT [dbo].[products] ([id], [available], [deadline], [description], [image], [name], [price], [categoryid]) VALUES (14, 50, CAST(N'2023-06-23 00:00:00.0000000' AS DateTime2), N'Honkai Impact 3rd Elysia Miss Pink Ver. 1/7', N'honkai_impact_3rd_elysia_miss_pink_ver.jpg', N'Honkai Impact 3rd Elysia Miss Pink Ver. 1/7', 100, 6)
INSERT [dbo].[products] ([id], [available], [deadline], [description], [image], [name], [price], [categoryid]) VALUES (15, 50, CAST(N'2023-06-23 00:00:00.0000000' AS DateTime2), N'Honkai Impact 3rd Fu Hua Cerulean Court Ver. 1/8', N'honkai_impact_3rd_fu_hua_cerulean_court_ver.jpg', N'Honkai Impact 3rd Fu Hua Cerulean Court Ver. 1/8', 100, 6)
INSERT [dbo].[products] ([id], [available], [deadline], [description], [image], [name], [price], [categoryid]) VALUES (16, 50, CAST(N'2023-06-23 00:00:00.0000000' AS DateTime2), N'Asteroid Series Honkai Impact 3rd Rita Rossweisse Umbral Rose', N'teroid_series_houkai_3rd_rita_rossweisse_dark_rose_complete_figure__2__adf54e4667dc4e998d452543f448880d_large.jpg', N'Asteroid Series Honkai Impact 3rd Rita Rossweisse Umbral Rose', 100, 6)
INSERT [dbo].[products] ([id], [available], [deadline], [description], [image], [name], [price], [categoryid]) VALUES (17, 50, CAST(N'2023-06-23 00:00:00.0000000' AS DateTime2), N'Nendoroid Hololive Houshou Marine', N'nendoroid_hololive_houshou_marine__2__5a2158c6497d4eaea77b1d5ad1a20185_large.jpg', N'Nendoroid Hololive Houshou Marine', 100, 5)
INSERT [dbo].[products] ([id], [available], [deadline], [description], [image], [name], [price], [categoryid]) VALUES (19, 50, CAST(N'2023-06-23 00:00:00.0000000' AS DateTime2), N'Nendoroid Hololive Production Shirakami Fubuki', N'nendoroid_hololive_production_shirakami_fubuki__3__36b3b698221147bca060efb1377e9205_large.jpg', N'Nendoroid Hololive Production Shirakami Fubuki', 100, 5)
INSERT [dbo].[products] ([id], [available], [deadline], [description], [image], [name], [price], [categoryid]) VALUES (20, 50, CAST(N'2023-06-23 00:00:00.0000000' AS DateTime2), N'Nendoroid Hololive Production Mori Calliope', N'nendoroid_hololive_production_mori_calliope__3__f82a220688974ea6957c26bef10962a5_large.jpg', N'Nendoroid Hololive Production Mori Calliope', 100, 5)
INSERT [dbo].[products] ([id], [available], [deadline], [description], [image], [name], [price], [categoryid]) VALUES (21, 50, CAST(N'2023-06-23 00:00:00.0000000' AS DateTime2), N'Nendoroid Hololive Production Shishiro Botan', N'nendoroid_hololive_production_shishiro_botan__4__921b2d0b71d046ca86d038fd51f822c7_large.jpg', N'Nendoroid Hololive Production Shishiro Botan', 100, 5)
INSERT [dbo].[products] ([id], [available], [deadline], [description], [image], [name], [price], [categoryid]) VALUES (23, 1, CAST(N'2023-06-23 00:00:00.0000000' AS DateTime2), N'Nendoroid Hololive Production Yukihana Lamy', N'nendoroid_hololive_production_yukihana_lamy__2__cfb757e85002481b9326149f4a5ea823_large.jpg', N'Nendoroid Hololive Production Yukihana Lamy', 100, 5)
INSERT [dbo].[products] ([id], [available], [deadline], [description], [image], [name], [price], [categoryid]) VALUES (24, 4, CAST(N'2023-06-23 00:00:00.0000000' AS DateTime2), N'Genshin Impact Aether 1/7', N'genshin_impact_aether_1__1__43eefd2c22d4404095e0e5ec9f42f32f_large.jpg', N'Genshin Impact Aether 1/7', 100, 4)
INSERT [dbo].[products] ([id], [available], [deadline], [description], [image], [name], [price], [categoryid]) VALUES (25, 50, CAST(N'2023-06-23 00:00:00.0000000' AS DateTime2), N'Genshin Impact Lumine 1/7', N'genshin_impact_lumine_1__1__267435f7710a4935a86912fa9f6e4c07_large.jpg', N'Genshin Impact Lumine 1/7', 100, 4)
INSERT [dbo].[products] ([id], [available], [deadline], [description], [image], [name], [price], [categoryid]) VALUES (26, 50, CAST(N'2023-06-23 00:00:00.0000000' AS DateTime2), N'Nendoroid Genshin Impact Traveler ( Lumine )', N'nendoroid_genshin_impact_traveler__lumine___3__07d3edb75f1f46d69cca290542af7060_large.jpg', N'Nendoroid Genshin Impact Traveler ( Lumine )', 100, 4)
INSERT [dbo].[products] ([id], [available], [deadline], [description], [image], [name], [price], [categoryid]) VALUES (27, 50, CAST(N'2023-06-23 00:00:00.0000000' AS DateTime2), N'Nendoroid Genshin Impact Traveler ( Aether )', N'nendoroid_genshin_impact_traveler__aether___3__1889df7805e84bf0a4d99c408d4a2e75_large.jpg', N'Nendoroid Genshin Impact Traveler ( Aether )', 100, 4)
INSERT [dbo].[products] ([id], [available], [deadline], [description], [image], [name], [price], [categoryid]) VALUES (28, 50, CAST(N'2023-06-23 00:00:00.0000000' AS DateTime2), N'Nendoroid Genshin Impact Venti', N'nendoroid_genshin_impact_venti__2__82fbc8f4312d4a56bde130abbf924fa8_large.jpg', N'Nendoroid Genshin Impact Venti', 100, 4)
INSERT [dbo].[products] ([id], [available], [deadline], [description], [image], [name], [price], [categoryid]) VALUES (29, 50, CAST(N'2023-06-23 00:00:00.0000000' AS DateTime2), N'Genshin Impact Ningguang Gold Leaf and Pearly Jade Ver. 1/7', N'genshin_impact_ningguang_gold_leaf_and_pearly_jade_ver.jpg', N'Genshin Impact Ningguang Gold Leaf and Pearly Jade Ver. 1/7', 100, 4)
INSERT [dbo].[products] ([id], [available], [deadline], [description], [image], [name], [price], [categoryid]) VALUES (30, 50, CAST(N'2023-06-23 00:00:00.0000000' AS DateTime2), N'CAworks Anime "KonoSuba" Megumin Anime Opening Edition 1/7', N'caworks_anime_konosuba_megumin_anime_opening_edition_1__2__8a86737beba1460d951be89f69b70870_large.jpg', N'CAworks Anime "KonoSuba" Megumin Anime Opening Edition 1/7', 100, 7)
INSERT [dbo].[products] ([id], [available], [deadline], [description], [image], [name], [price], [categoryid]) VALUES (31, 50, CAST(N'2023-06-23 00:00:00.0000000' AS DateTime2), N'TV Anime "Komi-san wa, Komyushou desu." Shouko Komi 1/7', N'tv_anime_komi-san_wa__komyushou_desu.jpg', N'TV Anime "Komi-san wa, Komyushou desu." Shouko Komi 1/7', 100, 7)
INSERT [dbo].[products] ([id], [available], [deadline], [description], [image], [name], [price], [categoryid]) VALUES (32, 10, CAST(N'2023-06-23 00:00:00.0000000' AS DateTime2), N'Anime "JoJo''s Bizarre Adventure Stone Ocean" Jotaro Kujo Figure Pen', N'anime_jojo_s_bizarre_adventure_stone_ocean_jotaro_kujo_figure_pen__2__f69e0f1d7df74ab0b35166ebdb0aa191_large.jpg', N'Anime "JoJo''s Bizarre Adventure Stone Ocean" Jotaro Kujo Figure Pen', 100, 7)
INSERT [dbo].[products] ([id], [available], [deadline], [description], [image], [name], [price], [categoryid]) VALUES (33, 50, CAST(N'2023-06-23 00:00:00.0000000' AS DateTime2), N'Anime "The Master of Diabolism" Lan Wangji Chilhood Ver. 1/8', N'anime_the_master_of_diabolism_lan_wangji_chilhood_ver.jpg', N'Anime "The Master of Diabolism" Lan Wangji Chilhood Ver. 1/8', 100, 7)
INSERT [dbo].[products] ([id], [available], [deadline], [description], [image], [name], [price], [categoryid]) VALUES (34, 10, CAST(N'2023-06-23 00:00:00.0000000' AS DateTime2), N'Majo no Tabitabi - Elaina - F:Nex - 1/7 (FuRyu)', N'majo_no_tabitabi_elaina_1__2__31fd3efc26554a8ca37c6584386187ab_medium.jpg', N'Majo no Tabitabi - Elaina - F:Nex - 1/7 (FuRyu)', 100, 7)
INSERT [dbo].[products] ([id], [available], [deadline], [description], [image], [name], [price], [categoryid]) VALUES (36, 50, CAST(N'2023-06-23 00:00:00.0000000' AS DateTime2), N'POP UP PARADE Chainsaw Man', N'pop_up_parade_chainsaw_man__2__5cf3f9cd31d84e55aad2c3fc29cb6044_medium.jpg', N'POP UP PARADE Chainsaw Man', 100, 7)
SET IDENTITY_INSERT [dbo].[products] OFF
ALTER TABLE [dbo].[cart_item]  WITH CHECK ADD  CONSTRAINT [FKj363ybleogs0ctc9mlsmssm9k] FOREIGN KEY([product_id_id])
REFERENCES [dbo].[products] ([id])
GO
ALTER TABLE [dbo].[cart_item] CHECK CONSTRAINT [FKj363ybleogs0ctc9mlsmssm9k]
GO
ALTER TABLE [dbo].[orderdetails]  WITH CHECK ADD  CONSTRAINT [FKaltatpxipsjtcih4d1h6bn0xr] FOREIGN KEY([productid])
REFERENCES [dbo].[products] ([id])
GO
ALTER TABLE [dbo].[orderdetails] CHECK CONSTRAINT [FKaltatpxipsjtcih4d1h6bn0xr]
GO
ALTER TABLE [dbo].[orderdetails]  WITH CHECK ADD  CONSTRAINT [FKj4gc2ja2otvwemf4rho2lp3s8] FOREIGN KEY([orderid])
REFERENCES [dbo].[orders] ([id])
GO
ALTER TABLE [dbo].[orderdetails] CHECK CONSTRAINT [FKj4gc2ja2otvwemf4rho2lp3s8]
GO
ALTER TABLE [dbo].[orders]  WITH CHECK ADD  CONSTRAINT [FKk3cjfcgb621qhahps1tre43e4] FOREIGN KEY([username])
REFERENCES [dbo].[accounts] ([username])
GO
ALTER TABLE [dbo].[orders] CHECK CONSTRAINT [FKk3cjfcgb621qhahps1tre43e4]
GO
ALTER TABLE [dbo].[products]  WITH CHECK ADD  CONSTRAINT [FK1krrsjgcawsfg8k8u4hm5gi8q] FOREIGN KEY([categoryid])
REFERENCES [dbo].[categories] ([id])
GO
ALTER TABLE [dbo].[products] CHECK CONSTRAINT [FK1krrsjgcawsfg8k8u4hm5gi8q]
GO
