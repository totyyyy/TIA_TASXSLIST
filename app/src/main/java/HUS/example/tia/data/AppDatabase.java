package HUS.example.tia.data;
import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import HUS.example.tia.data.SubjectTable.MySubject;
import HUS.example.tia.data.SubjectTable.MySubjectQuery;
import HUS.example.tia.data.mytasxstable.MyTask;
import HUS.example.tia.data.mytasxstable.MyTaskQuery;
import HUS.example.tia.data.usersTable.MyUser;
import HUS.example.tia.data.usersTable.MyUserQuery;

public class AppDatabase {

    /*
    تعريف الجداول ورقم الاصدار
    version
    عند تغيير اي شي يخص جدول او جداول علينا تغيير رقم الاصدار
    ليتم بناء قاعدة البيانات من جديد
    */
    @Database(entities = {MyUser.class, MySubject.class, MyTask.class},version = 1)
/**
 * الفئة المسؤولة عن بناء قاعدة البايانات بكل جداولها
 * وتوفر لنا كائن للتعامل مع قاعدة البيانات
 */
    public abstract class  AppDataBase extends RoomDatabase
    {

        /**
         * كائن للتعامل مع قاعدة البيانات
         */
        private static AppDataBase db;

        /**
         * يعيد كائن لعمليات جدول المستعملين
         * @return
         */
        public abstract MyUserQuery getMyUserQuery();

        /**
         * يعيد كائن لعمليات جدول المواضيع
         * @return
         */

        public abstract MySubjectQuery getMySubjectQuery();

        /**
         * يعيد كائن لعمليات جدول المهمات
         * @return
         */
        public abstract MyTaskQuery getMyTaskQuery();

        /**
         * بناء قاعدة البيانات واعادة كائن يؤشر عليها
         * @param context
         * @return
         */
        public static AppDatabase getDb(Context context){
            if(db==null)
            {
                db= Room.databaseBuilder(context,AppDataBase.class,"samihDataBase")
                        .fallbackToDestructiveMigration()
                        .allowMainThreadQueries()
                        .build();

            }
    return db;
     }
    }

