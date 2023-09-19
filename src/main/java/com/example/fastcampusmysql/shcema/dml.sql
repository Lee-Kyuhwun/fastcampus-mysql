-- Timeline 테이블에 대한 더미 데이터 삽입
INSERT INTO Timeline (memberId, postId, createdAt) VALUES
                                                       (1, 1, '2023-09-18 10:00:00'),
                                                       (2, 2, '2023-09-18 11:00:00'),
                                                       (3, 3, '2023-09-18 12:00:00'),
                                                       (4, 4, '2023-09-19 09:00:00'),
                                                       (5, 5, '2023-09-19 10:30:00');


-- Post 테이블에 대한 더미 데이터 삽입
INSERT INTO POST (memberId, contents, createdDate, createdAt, likeCount, version) VALUES
                                                                                      (1, 'string', '2023-09-18', '2023-09-18 10:00:00', NULL, 0),
                                                                                      (1, 'string', '2023-09-18', '2023-09-18 12:00:00', NULL, 0),
                                                                                      (1, 'Checking out the third post!', '2023-09-19', '2023-09-19 08:00:00', NULL, 0),
                                                                                      (1, 'Last but not least, the fourth post.', '2023-09-20', '2023-09-20 09:30:00', NULL, 0);

