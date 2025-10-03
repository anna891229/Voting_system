-- 查詢所有 Idol
DELIMITER $$
CREATE PROCEDURE SelectIdol()
BEGIN
    SELECT *
    FROM idol
    ORDER BY vote_count DESC;
END$$
DELIMITER ;

-- 查詢投票紀錄
DELIMITER $$
CREATE PROCEDURE SelectRecord()
BEGIN
    SELECT *
    FROM voterecord;
END$$
DELIMITER ;

-- 新增idol
DELIMITER $$
CREATE PROCEDURE insertIdol(
    IN idol_name VARCHAR(100)
)
BEGIN
    INSERT INTO Idol (idol_name, vote_count) 
    VALUES (idol_name,0);
END$$
DELIMITER ;

-- 新增投票紀錄並更新票數
DELIMITER $$
CREATE PROCEDURE AddVoteRecord(
    IN voter VARCHAR(100),
    IN votedidolid INT
)
BEGIN
    INSERT INTO voterecord(voter, votedidolid) 
    VALUES (voter,votedidolid);

    UPDATE idol
    SET vote_count=vote_count + 1
    WHERE id=votedidolid;
END$$
DELIMITER ;

-- 刪除 Idol
DELIMITER $$
CREATE PROCEDURE DeleteIdol(
    IN idol_id INT
)
BEGIN
    DELETE FROM idol WHERE id=idol_id;
END$$
DELIMITER ;