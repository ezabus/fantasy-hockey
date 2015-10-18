INSERT INTO player (playerID, name) VALUES (111, 'User');
INSERT INTO team (teamID, name, currentPos, playerID) VALUES (1111, 'North Lake Wonders', 10, 111);
INSERT INTO squad (squadID, points, dailyPoints, weeklyPoints, overalRank, dailyRank, weeklyRank, dateCode, teamID)
    VALUES ('1111_2015/10/16', 500, 100, 300, 10, 20, 15, '2015/10/16', 1111);