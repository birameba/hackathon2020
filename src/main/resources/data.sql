/* Insert into Table Roles*/

INSERT  INTO `roles` (`id`, `name`) VALUES (2, N'ROLE_ADMIN');
INSERT INTO `roles` (`id`, `name`) VALUES (1, N'ROLE_USER') ;
/* Insert into Table Roles*/
INSERT into `users`(`name`,`username`,`email`,`password`) VALUES('Birame Ba','birame','birame774@gmail.com','$2a$10$dOXWGjq0awgc.xvR1SfXj.GsRwAaGML/DL4Wl31LPFo1D3g2bvAzK') ;
/* Insert into Table user_roles*/
INSERT INTO `user_roles`(`user_id`, `role_id`) VALUES (1,1);
/* Insert into Table Todolist*/
INSERT INTO `todolist`(`id`, `completed`, `description`, `nom`, `utilisateur`) VALUES (1,0,'todo item Description','My todo item name',1);
