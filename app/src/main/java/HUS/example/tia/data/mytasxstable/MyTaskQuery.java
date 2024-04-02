package HUS.example.tia.data.mytasxstable;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

/**
 * واجهة استعلامات على جدول معطيات
 */
@Dao
public interface MyTaskQuery
{
    /**
     * اعادة جميع معطيات جدول المهمات
     * @return * قائمة من المهمات
     */
    @Query("SELECT * FROM MyTask ORDER BY importance DESC")
    List<MyTask>getAllTasks();
/**
 * رجاع المهمات حسب المستعمل واذا انتهت ام لا ومرتبة تنازليا حسب الاهمية
 * @param userid_p رقم المستعمل *
 *@return
 */
@Query("SELECT * FROM MyTask WHERE userld=:userid_p ORDER BY time DESC")
    List<MyTask>getAllTaskOrderBy(long userid_p);
/**
 * ارجاع المهمات حسب المستعمل واذا انتهت ام لا ومرتبة تنازليا حسب الاهمية
 * @param userid_p رقم المستعمل *
 * @param isCompleted_p هل تمت ام لا *
 * @return
 */
@Query("SELECT * FROM MyTask WHERE userld =:userid_p AND isCompleted=: isCompleted_p"+ "ORDER By importance DESC")
    List<MyTask>getAllTaskOrderBy(long userid_p,boolean isCompleted_p);
/**
 * ادخال مهمات
 * @param t * مجموعة مهمات
 */
@Insert
    void insertTask(MyTask... t) // ثلاثة نقاط تعني مجموعة
    /**
     * تعديل المهمات
     * @param   * (التعديل حسب المفتاح الرئيسي) مجموعة مهمات للتعديل
     */
    @Update
    void updateTask(MyTask...tasks);
    /**
     * حذف مهمة او مهمات
     * @param tasks * (حسب المفتاح الرئيسي) حذف المهمات
     */
    @Delete
    void deleteTask(long kid);
    /**
     * استخراج جميع المهمات التابعة لرقم الموضوع
     * @param key_id
     *
     */
    @Query("DELETE FROM MyTask WHERE subjld= :key_id)
            void deleteTask(long kid);
    /**
     * استخراج جميع المهمات التابعة لرقم الموضوع
     * @param key_id رقم الموضوع
     * @return
     */
    @Query("SELECT * FROM MyTask WHERE subjld= : key_id" + "ORDER BY importance DESC")
    List<MyTask> getTasksBySubjld(long key_id);
}
