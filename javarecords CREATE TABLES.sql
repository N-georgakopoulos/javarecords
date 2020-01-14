DROP TABLE listOfVenues
DROP TABLE Artists
DROP TABLE Albums
DROP TABLE Songs
DROP TABLE Managers
DROP TABLE Studios
DROP TABLE Partners


CREATE TABLE IF NOT EXISTS Managers( managerid int,
							 username char(30),
							 managerpassword char(50),
                             PRIMARY KEY (managerid))

CREATE TABLE IF NOT EXISTS listOfVenues(venueid int,
						   venuename char(30),
						   distanceVenueArtist int,
						   OrganizerName char(30),
                           Ventype char(50),
                           style char(50),
                           location char (20),
                           clean char(30),
                           veninstall char(20),
                           duration int,
                           cut char(20),
                           PRIMARY KEY (venueid))


CREATE TABLE IF NOT EXISTS  Artists(
    artistid int,
    username char(30) NOT NULL,
    password char(30),
    rating decimal(10,2),
     relevancyIndex decimal(10,2),
    payPercentage decimal(10,2),  
    managerid int,    
    PRIMARY KEY (artistid),
	FOREIGN KEY (managerid) REFERENCES Managers(managerid))
    
                         
CREATE TABLE IF  NOT EXISTS Albums(albumName char(30),
								   pricep decimal(10,2),
                                   priced decimal(10,2),
                                   physical int,
                                   digital int,
                                   artistid int,
                                   PRIMARY KEY (albumName),
                                   FOREIGN KEY (artistid) REFERENCES Artists(artistid))
                                   
                                   
CREATE TABLE IF NOT EXISTS Songs(songname char(30),
								 albumName char(30),
								 FOREIGN KEY(albumName) REFERENCES Albums(albumName))
                                 
CREATE TABLE IF NOT EXISTS Partners(partname char(20),
								    attribute char(30),
                                    payPerHour decimal(10,2),
                                    PRIMARY KEY (partname))
                                    
CREATE TABLE IF NOT EXISTS Studios(studioname char(30),
								   pricePerHour decimal(10,2),
                                   PRIMARY KEY (studioname))
                                    