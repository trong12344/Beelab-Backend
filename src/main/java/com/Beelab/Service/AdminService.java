package com.Beelab.Service;

import com.Beelab.Entity.Admin;

public interface AdminService {
	
		public Admin createAdmin(Admin admin);

		public Admin changePassword();

//		public Admin updateAdmin(Admin admin);

		public Admin findOneById(int id);

		public Admin findOneByEmail(String email);

		public Admin findOneByPhone(String phoneNumber);

		public void update(Admin admin);

		Admin updateAdmin(Admin admin);

		
}
