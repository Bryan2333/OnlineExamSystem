// 教师管理页面
<template>
  <div class="all">
    <el-table :data="pagination.records" border>
      <el-table-column prop="teacherId" label="teacherID" width="180"></el-table-column>
      <el-table-column  prop="teacherName" label="Name" width="180"></el-table-column>
      <el-table-column prop="sex" label="Sex" width="120"></el-table-column>
      <el-table-column prop="institute" label="Institute" width="200"></el-table-column>
      <el-table-column prop="phone" label="Phone Num" width="120"></el-table-column>
      <el-table-column prop="email" label="Email" width="160"></el-table-column>
      <el-table-column prop="cardId" label="Card ID" width="120"></el-table-column>
      <el-table-column prop="type" label="Type" width="120"></el-table-column>
      <el-table-column  label="Operation" >
        <template slot-scope="scope">
          <el-button @click="checkGrade(scope.row.teacherId)" type="primary" size="small">Edit</el-button>
          <el-button @click="deleteById(scope.row.teacherId)" type="danger" size="small">Delete</el-button>
        </template>
      </el-table-column>
    </el-table>
    <el-pagination
        @size-change="handleSizeChange"
        @current-change="handleCurrentChange"
        :current-page="pagination.current"
        :page-sizes="[6, 10]"
        :page-size="pagination.size"
        layout="total, sizes, prev, pager, next, jumper"
        :total="pagination.total"
        class="page">
    </el-pagination>
    <!-- 编辑对话框-->
    <el-dialog
        title="Edit teacher information"
        :visible.sync="dialogVisible"
        width="30%"
        :before-close="handleClose">
      <section class="update">
        <el-form ref="form" :model="form" label-width="100px">
          <el-form-item label="Name">
            <el-input v-model="form.teacherName"></el-input>
          </el-form-item>
          <el-form-item label="Institute">
            <el-input v-model="form.institute"></el-input>
          </el-form-item>
          <el-form-item label="Sex">
            <el-input v-model="form.sex"></el-input>
          </el-form-item>
          <el-form-item label="Phone Num">
            <el-input v-model="form.phone"></el-input>
          </el-form-item>
          <el-form-item label="Email">
            <el-input v-model="form.email"></el-input>
          </el-form-item>
          <el-form-item label="Password">
            <el-input v-model="form.password"></el-input>
          </el-form-item>
          <el-form-item label="Card ID">
            <el-input v-model="form.cardId"></el-input>
          </el-form-item>
          <el-form-item label="Type">
            <el-input v-model="form.type"></el-input>
          </el-form-item>
        </el-form>
      </section>
      <span slot="footer" class="dialog-footer">
        <el-button @click="dialogVisible = false">Cancel</el-button>
        <el-button type="primary" @click="submit()">Submit</el-button>
      </span>
    </el-dialog>
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
        size: 6, //每页条数
      },
      dialogVisible: false, //对话框
      form: {}, //保存点击以后当前试卷的信息
    };
  },
  created() {
    this.getTeacherInfo();
  },
  methods: {
    getTeacherInfo() {
      //分页查询所有试卷信息
      this.$axios(`/teacher`, {
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
      this.getTeacherInfo();
    },
    //改变当前页码，重新发送请求
    handleCurrentChange(val) {
      this.pagination.current = val;
      this.getTeacherInfo();
    },
    checkGrade(teacherId) { //修改教师信息
      this.dialogVisible = true
      this.$axios(`/teacher/${teacherId}`).then(res => {
        this.form = res.data.data
      })
    },
    deleteById(teacherId) { //删除当前学生
      this.$confirm("Are you sure to delete the teacher? It's unrecoverable", "Warning", {
        confirmButtonText: 'Sure',
        cancelButtonText: 'Cancel',
        type: 'danger'
      }).then(() => { //确认删除
        this.$axios({
          url: `/teacher/${teacherId}`,
          method: 'delete',
        }).then(res => {
          this.getTeacherInfo()
        })
      }).catch(() => {

      })
    },
    submit() { //提交更改
      this.dialogVisible = false
      this.$axios({
        url: '/teacher',
        method: 'put',
        data: {
          ...this.form
        }
      }).then(res => {
        console.log(res)
        if (res.data.code === 200) {
          this.$message({
            message: '更新成功',
            type: 'success'
          })
        }
        this.getTeacherInfo()
      })
    },
    handleClose(done) { //关闭提醒
      this.$confirm('Are you sure to close?', {
        confirmButtonText: 'Sure',
        cancelButtonText: 'Cancel',
        type: 'danger'
      })
          .then(_ => {
            done();
          }).catch(_ => {
      });
    },
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
