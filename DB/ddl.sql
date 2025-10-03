CREATE DATABASE VotingSystem;

USE VotingSystem;

CREATE TABLE Idol(
    id INT AUTO_INCREMENT PRIMARY KEY,
    idol_name VARCHAR(100),
    vote_count Int
);

CREATE TABLE VoteRecord(
    id INT AUTO_INCREMENT PRIMARY KEY,
    voter VARCHAR(100),
    votedidolid INT
);