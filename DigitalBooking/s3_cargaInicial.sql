INSERT INTO Cities ( city_name, country)VALUES ( 'Córdoba', 'Argentina');
INSERT INTO Cities (city_name, country)VALUES ('Buenos Aires', 'Argentina');
INSERT INTO Cities (city_name, country)VALUES ('San Carlos de Bariloche', 'Argentina');
INSERT INTO Cities (city_name, country)VALUES ('Mendoza', 'Argentina');
INSERT INTO Cities (city_name,country) VALUES ('Berazategui', 'Argentina');
INSERT INTO Cities (city_name,country) VALUES ('Viedma', 'Argentina');
INSERT INTO Cities (city_name,country) VALUES ('Chaltén', 'Argentina');
INSERT INTO Cities (city_name,country) VALUES ('Calafate', 'Argentina');
INSERT INTO Cities (city_name,country) VALUES ('Puerto Iguazú', 'Argentina');
INSERT INTO Cities (city_name,country) VALUES ('Oberá', 'Argentina');
INSERT INTO Cities (city_name,country) VALUES ('Caviahue', 'Argentina');
INSERT INTO Cities (city_name,country) VALUES ('Chascomús', 'Argentina');
INSERT INTO Cities (city_name,country) VALUES ('Zapala', 'Argentina');
INSERT INTO Cities (city_name,country) VALUES ('Mar del Plata', 'Argentina');
INSERT INTO Cities (city_name,country) VALUES ('Pinamar', 'Argentina');
INSERT INTO Cities (city_name,country) VALUES ('Villa Carlos Paz', 'Argentina');
INSERT INTO Cities (city_name,country) VALUES ('Rosario', 'Argentina');
INSERT INTO Cities (city_name,country) VALUES ('San Martín de los Andes', 'Argentina');

INSERT INTO Categories (title,description, image_url)VALUES ('Hoteles', ' ', ' ');
INSERT INTO Categories (title, description, image_url)VALUES ('Hostels', ' ', ' ');
INSERT INTO Categories (title, description, image_url)VALUES ('Departamentos', ' ', ' ');
INSERT INTO Categories (title, description, image_url)VALUES ('Bed and breakfast', ' ', ' ');

INSERT INTO Policies (documentation, penalty_fee)VALUES ('Horario de Check in: 14:00', 549.5);
INSERT INTO Policies (documentation, penalty_fee)VALUES ('Horario de Check out: 10:00', 549.5);
INSERT INTO Policies (documentation, penalty_fee)VALUES ('Para el acceso al gimnasio y a la piscina, se requiere contar con pase sanitario covid-19 ', 932.32);
INSERT INTO Policies (documentation, penalty_fee)VALUES ('El ingreso de menores con la cama extra tiene un costo adicional ', 1599.00);



INSERT INTO Images (title_image, url_image) VALUES ('imagen1_HotelRoyal', '\imagen1_HotelRoyal');
INSERT INTO Images (title_image, url_image) VALUES ('imagen2_HotelRoyal', '\imagen2_HotelRoyal');
INSERT INTO Images (title_image, url_image) VALUES ('imagen3_HotelRoyal', '\imagen3_HotelRoyal');
INSERT INTO Images (title_image, url_image) VALUES ('imagen1_HotelAmerian', '\imagen1_HotelAmerian');
INSERT INTO Images (title_image, url_image) VALUES ('imagen2_HotelAmerian', '\imagen2_HotelAmerian');
INSERT INTO Images (title_image, url_image) VALUES ('imagen3_HotelAmerian', '\imagen3_HotelAmerian');
INSERT INTO Images (title_image, url_image) VALUES ('imagen4_HotelAmerian', '\imagen4_HotelAmerian');
INSERT INTO Images (title_image, url_image) VALUES ('imagen1_HotelPanamericano', '\imagen1_HotelPanamericano');
INSERT INTO Images (title_image, url_image) VALUES ('imagen2_HotelPanamericano', '\imagen2_HotelPanamericano');
INSERT INTO Images (title_image, url_image) VALUES ('imagen3_HotelPanamericano', '\imagen3_HotelPanamericano');
INSERT INTO Images (title_image, url_image) VALUES ('imagen4_HotelPanamericano', '\imagen4_HotelPanamericano');


INSERT INTO Features (description, icon)VALUES ('Estacionamiento', 'icon_estacionamiento');
INSERT INTO Features (description, icon)VALUES ('WIFI', 'icon_Wifi ');
INSERT INTO Features (description, icon)VALUES ('Aire acondicionado en zonas comunes', 'icon_aireAcondicionado ');
INSERT INTO Features (description, icon)VALUES ('Piscina', 'icon_piscina ');
INSERT INTO Features (description, icon)VALUES ('Lavandería', 'icon_lavandería ');
INSERT INTO Features (description, icon)VALUES ('Cocina', 'icon_cocina');
INSERT INTO Features (description, icon)VALUES ('Spa', 'icon_spa ');
INSERT INTO Features (description, icon)VALUES ('Gimnasio', 'icon_gimnasio');
INSERT INTO Features (description, icon)VALUES ('Caja de Seguridad', 'icon_cajaSeguridad ');
INSERT INTO Features (description, icon)VALUES ('Hidromasaje', 'icon_hidromasaje');
INSERT INTO Features (description, icon)VALUES ('Restaurante', 'icon_restaurante');
INSERT INTO Features (description, icon)VALUES ('Servicio despertador', 'icon_-despertador');


INSERT INTO roles (role_name)VALUES ('Administrador');
INSERT INTO roles (role_name)VALUES ('Usuario');

UPDATE db_prod.roles SET role_name ='ROLE_ADMIN' WHERE id=1;
UPDATE db_prod.roles SET role_name ='ROLE_USER' WHERE id=2;

INSERT INTO Users (name, surname, email, password, city, role_id)VALUES ('Carla', 'Antonini', 'carla.g.antonini@gmail.com', 'carli1234', 'Buenos Aires', 1);
INSERT INTO Users (name, surname, email, password, city, role_id)VALUES ('Manuel', 'Pérez ', 'manu2022@gmail.com', 'Manu1234', 'Buenos Aires', 2);
INSERT INTO Users (name, surname, email, password, city, role_id)VALUES ('Franco', 'Fernandez', 'fran123@gmail.com', 'Fran1234', 'Bariloche', 2);
INSERT INTO Users (name, surname, email, password, city, role_id)VALUES ('Andrea', 'Canale ', 'andre_2022@gmail.com', 'Andre1234', 'Córdoba', 2);
INSERT INTO Users (name, surname, email, password, city, role_id)VALUES ('Federico', 'Larreta', 'fede_22@gmail.com', 'Fede1234', 'Mendoza', 2);


INSERT INTO Products (address, description, description_title, rating, title, categories_d, cities_id, policies_id)
VALUES ('Buenos Aires, Ciudad Autónoma de Buenos Aires, Argentina, A 940 m del Centro', 'Localizado en el Barrio de Puerto Madero en Buenos Aires, el Hotel se encuentra a 3 km del Obelisco, 20 minutos en coche de la Plaza de Mayo y a 32 km del Aeropuerto Internacional Ministro Pistarini de Ezeiza.', ' Alójate en el corazón de Buenos Aires', 8, 'Hermitage Hotel', 1, 2, 1);


INSERT INTO Reservations (check_in_time, check_in_date, check_out_date, Users_id_user, Products_id_product)
VALUES ('14:15', '2022-11-17 ', '2022-11-20 ', 2, 1);

