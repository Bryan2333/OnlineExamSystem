// 所有学生
<template>
  <div class="all">
    <el-table :data="pagination.records" border>
      <el-table-column prop="studentId" label="ID" width="100"></el-table-column>
      <el-table-column prop="studentName" label="Name" width="120"></el-table-column>
      <el-table-column prop="institute" label="Institue" width="150"></el-table-column>
      <el-table-column prop="major" label="Major" width="180"></el-table-column>
      <el-table-column prop="grade" label="Grade" width="100"></el-table-column>
      <el-table-column prop="clazz" label="Class" width="80"></el-table-column>
      <el-table-column prop="sex" label="Sex" width="80"></el-table-column>
      <el-table-column prop="phone" label="Phone Num" width="120"></el-table-column>
      <el-table-column prop="email" label="Email"></el-table-column>
      <el-table-column fixed="right" label="Inquiry Grades">
        <template slot-scope="scope">
          <el-button @click="checkGrade(scope.row.studentId)" type="primary" size="small">Inquiry Grades</el-button>
        </template>
      </el-table-column>
    </el-table>
    <el-pagination
      @size-change="handleSizeChange"
      @current-change="handleCurrentChange"
      :current-page="pagination.current"
      :page-sizes="[5, 10]"
      :page-size="pagination.size"
      layout="total, sizes, prev, pager, next, jumper"
      :total="pagination.total"
      class="page"
    ></el-pagination>
  </div>
</template>

<script>
export default {
  data() {
    return {
      pagination: {
        //分页后的考试信息
        current: 1, //当前页
        total: null, //记录条数
        size: 5 //每页条数
      }
    };
  },
  created() {
    this.getAnswerInfo();
  },
  methods: {
    getAnswerInfo() {
      //分页查询所有试卷信息
      this.$axios('/student', {
        params: {
          pageNo: this.pagination.current,
          pageSize: this.pagination.size
        }
      }).then(res => {
        this.pagination = res.data.data;
      }).catch(error => {
        console.log(error)
      });
    },
    //改变当前记录条数
    handleSizeChange(val) {
      this.pagination.size = val;
      this.getAnswerInfo();
    },
    //改变当前页码，重新发送请求
    handleCurrentChange(val) {
      this.pagination.current = val;
      this.getAnswerInfo();
    },
    checkGrade(studentId) {
      this.$router.push({path: "/grade", query: {studentId: studentId}});
    }
  }
};
</script>
<style lang="less" scoped>
.all {
  padding: 0 40px;

  .page {
    margin-top: 20px;
    display: flex;
    justify-content: center;
    align-items: center;
  }

  .edit {
    margin-left: 20px;
  }

  .el-table tr {
    background-color: #dd5862 !important;
  }
}

.el-table .warning-row {
  background: #000 !important;
}

.el-table .success-row {
  background: #dd5862;
}
</style>
