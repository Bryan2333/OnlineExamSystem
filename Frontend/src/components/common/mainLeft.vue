<!--左边下拉导航栏-->
<template>
  <div id="left">
    <el-menu
        active-text-color="#dd5862"
        text-color="#00FFD4"
        :default-active="this.$route.path"
        class="el-menu-vertical-demo"
        @open="handleOpen"
        @close="handleClose"
        :collapse="flag"
        background-color="#124280"
        menu-trigger="click" router>
      <el-submenu v-for="(item,index) in menu" :index='item.index' :key="index">
        <template slot="title">
          <div class="left-width">
            <i class="iconfont" :class="item.icon"></i>
            <span slot="title" class="title">{{ item.title }}</span>
          </div>
        </template>
        <el-menu-item-group v-for="(list,index1) in item.content" :key="index1">
          <el-menu-item @click="handleTitle(item.index)" :index="list.path" v-if="list.item1 != null">{{ list.item1 }}
          </el-menu-item>
          <el-menu-item @click="handleTitle(item.index)" :index="list.path" v-if="list.item2 != null">{{ list.item2 }}
          </el-menu-item>
          <el-menu-item @click="handleTitle(item.index)" :index="list.path" v-if="list.item3 != null">{{ list.item3 }}
          </el-menu-item>
        </el-menu-item-group>
      </el-submenu>
    </el-menu>
  </div>
</template>

<script>
import {mapState} from 'vuex'

export default {
  name: "mainLeft",
  data() {
    return {}
  },
  computed: mapState(["flag", "menu"]),
  created() {
    this.addData()
  },
  methods: {
    handleOpen(key, keyPath) {
      // console.log(key, keyPath);
    },
    handleClose(key, keyPath) {
      // console.log(key, keyPath);
    },
    //点击标题传递参数给navigator组件
    handleTitle(index) {
      this.bus.$emit('sendIndex', index)
    },
    addData() {
      let role = this.$cookies.get("role")
      // 如果用户是管理员，则添加教师管理功能
      if (role === "0") {
        this.menu.push({
          index: '5',
          title: 'Teacher Management',
          icon: 'icon-Userselect',
          content: [{item1: 'Teacher Management', path: '/teacherManage'}, {item2: 'Add teacher', path: '/addTeacher'}],
        })
      }
    }
  },
}
</script>

<style>

.left-width .iconfont {
  font-size: 18px;
  color: #fff;
}

.left-width {
  width: 245px;
}

#left {
  background-color: #124280;
  z-index: 0;
  height: 960px;
}

#left .el-menu-vertical-demo .title {
  color: #fff;
  font-size: 16px;
  font-weight: bold;
  margin-left: 14px;
}

.el-submenu__title i {
  color: #fbfbfc !important;
}
</style>
