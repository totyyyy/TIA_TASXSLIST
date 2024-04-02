package HUS.example.tia.data.mytasxstable;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
@Entity
public class MyTask {
@PrimaryKey(autoGenerate = true)
    public long keyid;
  public long userid;
@ColumnInfo(name="full_Name")
  public String fullName;
  public String email;
  public String phone;
  public String importance;
  public boolean isCompleted;

  public void setKeyid(long keyid) {
    this.keyid = keyid;
  }

  public void setFullName(String fullName) {
    this.fullName = fullName;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public void setPassw(String passw) {
    this.passw = passw;
  }

  public String passw;

  public long getKeyid() {
    return keyid;
  }

  public String getFullName() {
    return fullName;
  }

  public String getEmail() {
    return email;
  }

  public String getPhone() {
    return phone;
  }

  public String getPassw() {
    return passw;
  }

  @Override
  public String toString() {
    return "MyTask{" +
            "keyid=" + keyid +
            ", fullName='" + fullName + '\'' +
            ", email='" + email + '\'' +
            ", phone='" + phone + '\'' +
            ", passw='" + passw + '\'' +
            '}';
  }
}
