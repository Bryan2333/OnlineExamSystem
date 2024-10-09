//查询所有考试
<template>
  <div class="exam">
    <el-table :data="pagination.records" border>
      <el-table-column
        fixed="left"
        prop="source"
        label="Exam Name"
        width="120"
      ></el-table-column>
      <el-table-column
        prop="description"
        label="Description"
        width="200"
      ></el-table-column>
      <el-table-column
        prop="institute"
        label="Institute"
        width="120"
      ></el-table-column>
      <el-table-column prop="major" label="Major" width="150"></el-table-column>
      <el-table-column prop="grade" label="Grade" width="80"></el-table-column>
      <el-table-column
        prop="examDate"
        label="Exam Date"
        width="120"
      ></el-table-column>
      <el-table-column
        prop="totalTime"
        label="Total Time"
        width="100"
      ></el-table-column>
      <el-table-column
        prop="totalScore"
        label="Total Score"
        width="100"
      ></el-table-column>
      <el-table-column
        prop="type"
        label="Exam Type"
        width="100"
      ></el-table-column>
      <el-table-column
        prop="tips"
        label="Examinee Guidelines"
        width="400"
      ></el-table-column>
      <el-table-column fixed="right" label="Operation" width="150">
        <template slot-scope="scope">
          <el-button
            @click="edit(scope.row.examCode)"
            type="primary"
            size="small"
            >Edit</el-button
          >
          <el-button
            @click="deleteRecord(scope.row.examCode)"
            type="danger"
            size="small"
            >Del</el-button
          >
        </template>
      </el-table-column>
    </el-table>
    <el-pagination
      @size-change="handleSizeChange"
      @current-change="handleCurrentChange"
      :current-page="pagination.current"
      :page-sizes="[4, 8, 10, 20]"
      :page-size="pagination.size"
      layout="total, sizes, prev, pager, next, jumper"
      :total="pagination.total"
      class="page"
    >
    </el-pagination>
    <!-- 编辑对话框-->
    <el-dialog
      title="Edit Exam Info"
      :visible.sync="dialogVisible"
      width="40%"
      :before-close="handleClose"
    >
      <section class="update">
        <el-form ref="form" :model="form" label-width="150px">
          <el-form-item label="Exam Name">
            <el-input v-model="form.source"></el-input>
          </el-form-item>
          <el-form-item label="Description">
            <el-input v-model="form.description"></el-input>
          </el-form-item>
          <el-form-item label="Institute">
            <el-input v-model="form.institute"></el-input>
          </el-form-item>
          <el-form-item label="Major">
            <el-input v-model="form.major"></el-input>
          </el-form-item>
          <el-form-item label="Grade">
            <el-input v-model="form.grade"></el-input>
          </el-form-item>
          <el-form-item label="Exam Date">
            <el-col :span="11">
              <el-date-picker
                type="date"
                placeholder="Select date"
                v-model="form.examDate"
                style="width: 100%"
              ></el-date-picker>
            </el-col>
          </el-form-item>
          <el-form-item label="Total Time">
            <el-input v-model="form.totalTime"></el-input>
          </el-form-item>
          <el-form-item label="Total Score">
            <el-input v-model="form.totalScore"></el-input>
          </el-form-item>
          <el-form-item label="Exam Type">
            <el-input v-model="form.type"></el-input>
          </el-form-item>
          <el-form-item label="Examinee Guidelines">
            <el-input type="textarea" v-model="form.tips"></el-input>
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
      form: {}, //保存点击以后当前试卷的信息
      pagination: {
        //分页后的考试信息
        current: 1, //当前页
        total: null, //记录条数
        size: 4, //每页条数
      },
      dialogVisible: false,
    };
  },
  created() {
    this.getExamInfo();
  },
  methods: {
    edit(examCode) {
      //编辑试卷
      this.dialogVisible = true;
      this.$axios(`/exam/${examCode}`).then((res) => {
        //根据试卷id请求后台
        if (res.data.code === 200) {
          this.form = res.data.data;
        }
      });
    },
    handleClose(done) {
      //关闭提醒
      this.$confirm("Sure to close?", {
          confirmButtonText: "",
        cancelButtonText: "Cancel",
      })
        .then((_) => {
          done();
        })
        .catch((_) => {});
    },
    submit() {
      //提交修改后的试卷信息
      this.dialogVisible = false;
      this.$axios({
        url: "/exam",
        method: "put",
        data: {
          ...this.form,
        },
      }).then((res) => {
        if (res.data.code === 200) {
          this.$message({
            //成功修改提示
            message: "更新成功",
            type: "success",
          });
        }
        this.getExamInfo();
      });
    },
    deleteRecord(examCode) {
      this.$confirm("Are you sure to delete the record", {
        confirmButtonText: "Delete",
        cancelButtonText: "Cancel",
        type: "danger",
      })
        .then(() => {
          //确认删除
          this.$axios({
            url: `/exam/${examCode}`,
            method: "delete",
          }).then((res) => {
            this.getExamInfo();
          });
        })
        .catch(() => {});
    },
    getExamInfo() {
      //分页查询所有试卷信息
      this.$axios("/exam", {
        params: {
          pageNo: this.pagination.current,
          pageSize: this.pagination.size,
        },
      })
        .then((res) => {
          this.pagination = res.data.data;
        })
        .catch((error) => {
          console.log(error);
        });
    },
    //改变当前记录条数
    handleSizeChange(val) {
      this.pagination.size = val;
      this.getExamInfo();
    },
    //改变当前页码，重新发送请求
    handleCurrentChange(val) {
      this.pagination.current = val;
      this.getExamInfo();
    },
  },
};
</script>
<style lang="less" scoped>
.exam {
  padding: 0px 40px;
  .page {
    margin-top: 20px;
    display: flex;
    justify-content: center;
    align-items: center;
  }
  .edit {
    margin-left: 20px;
  }
}
</style>
