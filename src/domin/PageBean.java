package domin;

import java.util.List;

/**
 * Created by Administrator on 2020/7/24.
 * 该页数据
 * 当前页
 * 总的记录数
 * 总的页数
 * 每页显示的记录数
 */
public class PageBean<T> {
    private int currentPage;//当前页
    private int totalPage;//总页数
    private int pageSize;//每页的记录数
    private int totalSize;//总的记录数
    private List<T> list;//当前页的学生集合

    public int getCurrentPage() {
        return currentPage;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public int getTotalSize() {
        return totalSize;
    }

    public List<T> getList() {
        return list;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public void setTotalSize(int totalSize) {
        this.totalSize = totalSize;
    }

    public void setList(List<T> list) {
        this.list = list;
    }
}
