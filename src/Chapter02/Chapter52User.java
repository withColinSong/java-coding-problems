package Chapter02;

import java.util.Date;

public final class Chapter52User {
    private final String nickname;
    private final String password;
    private final String firstname;
    private final String lastname;
    private final String email;
    private final Date created;

    private Chapter52User(UserBuilder builder) {
        this.nickname = builder.nickname;
        this.password = builder.password;
        this.firstname = builder.firstname;
        this.lastname = builder.lastname;
        this.email = builder.email;
        this.created = builder.created;
    }

    public static UserBuilder getBuilder(String nickname, String password) {
        return new Chapter52User.UserBuilder(nickname, password);
    }

    public static final class UserBuilder {
        private final String nickname;
        private final String password;
        private String firstname;
        private String lastname;
        private String email;
        private final Date created;

        public UserBuilder(String nickname, String password) {
            this.nickname = nickname;
            this.password = password;
            this.created = new Date();
        }

        public UserBuilder firstname(String firstname) {
            this.firstname = firstname;
            return this;
        }

        public UserBuilder lastname(String lastname) {
            this.lastname = lastname;
            return this;
        }

        public UserBuilder email(String email) {
            this.email = email;
            return this;
        }

        public Chapter52User build() {
            return new Chapter52User(this);
        }

    }

    public String getNickname() {
        return nickname;
    }

    public String getPassword() {
        return password;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getEmail() {
        return email;
    }

    public Date getCreated() {
        return new Date(created.getTime());
    }

    public static void main(String[] args) {
        Chapter52User user = getBuilder("song", "hello").build();
    }
}