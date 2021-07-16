package ua.edu.sumdu.j2ee.pohorila.hotelsys.model;

import org.springframework.context.annotation.Bean;

import java.util.Comparator;
import java.util.Locale;
import java.util.Objects;

public class User {
    String name;
    int managerId;
    int userId;
    int roleId;
    String phoneNum;
    int hotelID;

    public User(String name, int managerId, int userId, int roleId, String phoneNum, int hotelId) {
        this.name = name;
        this.managerId = managerId;
        this.userId = userId;
        this.roleId = roleId;
        this.phoneNum = phoneNum;
        this.hotelID = hotelId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getManagerId() {
        return managerId;
    }

    public void setManagerId(int managerId) {
        this.managerId = managerId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", managerId=" + managerId +
                ", userId=" + userId +
                ", roleId=" + roleId +
                ", phoneNum='" + phoneNum + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return managerId == user.managerId && userId == user.userId && roleId == user.roleId && Objects.equals(name, user.name) && Objects.equals(phoneNum, user.phoneNum);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, managerId, userId, roleId, phoneNum);
    }

    public int getHotelID() {
        return hotelID;
    }

    public void setHotelID(int hotelID) {
        this.hotelID = hotelID;
    }

    public static Comparator<User> nameComparator = new Comparator<User>() {
        @Override
        public int compare(User o1, User o2) {
            String first = o1.getName().toUpperCase(Locale.ROOT);
            String second = o2.getName().toUpperCase(Locale.ROOT);
            return first.compareTo(second);
        }
    };

    public static Comparator<User> phoneComparator = new Comparator<User>() {
        @Override
        public int compare(User o1, User o2) {
            String first = o1.getPhoneNum().toUpperCase(Locale.ROOT);
            String second = o2.getPhoneNum().toUpperCase(Locale.ROOT);
            return first.compareTo(second);
        }
    };

    public static Comparator<User> managerIdComparator = new Comparator<User>() {
        @Override
        public int compare(User o1, User o2) {
            int first = o1.getManagerId();
            int second = o2.getManagerId();
            return first-second;
        }
    };

    public static Comparator<User> userIdComparator = new Comparator<User>() {
        @Override
        public int compare(User o1, User o2) {
            int first = o1.getUserId();
            int second = o2.getUserId();
            return first-second;
        }
    };

    public static Comparator<User> roleIdComparator = new Comparator<User>() {
        @Override
        public int compare(User o1, User o2) {
            int first = o1.getRoleId();
            int second = o2.getRoleId();
            return first-second;
        }
    };

    public static Comparator<User> hotelIdComparator = new Comparator<User>() {
        @Override
        public int compare(User o1, User o2) {
            int first = o1.getHotelID();
            int second = o2.getHotelID();
            return first-second;
        }
    };


}
