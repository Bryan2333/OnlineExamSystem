import VUE from 'vue'
import VUEX from 'vuex'

VUE.use(VUEX)

const state = {
  isPractice: false, //练习模式标志
  flag: false, //菜单栏左右滑动标志
  userInfo: null,
  menu: [{
      index: '1',
      title: 'Exam Manage',
      icon: 'icon-kechengbiao',
      content:[{item1:'Feature Introduction',path:'/examDescription'},{item2:'Exam Search',path:'selectExam'},{item3:'Add Exam',path:'/addExam'}],
    },
    {
      index: '2',
      title: 'Question Bank Manage',
      icon: 'icon-tiku',
      content:[{item1:'Feature Introduction',path:'/answerDescription'},{item2:'All Question Bank',path:'/selectAnswer'},{item3:'Add Question Bank',path:'/addAnswer'},{path: '/addAnswerChildren'}],
    },
    {
      index: '3',
      title: 'Grade Inquiry',
      icon: 'icon-performance',
      content:[{item1:'Student Grade Inquiry',path:'/allStudentsGrade'},{path: '/grade'},{item2: 'Grade Range Inquiry',path: '/selectExamToPart'},{path: '/scorePart'}],
    },
    {
      index: '4',
      title: 'Student Manage',
      icon: 'icon-role',
      content:[{item1:'Student Manage',path:'/studentManage'},{item2: 'Add Student',path: '/addStudent'}],
    },
  ],
}
const mutations = {
  practice(state,status) {
    state.isPractice = status
  },
  toggle(state) {
    state.flag = !state.flag
  },
  changeUserInfo(state,info) {
    state.userInfo = info
  }
}
const getters = {

}
const actions = {
  getUserInfo(context,info) {
    context.commit('changeUserInfo',info)
  },
  getPractice(context,status) {
    context.commit('practice',status)
  }
}
export default new VUEX.Store({
  state,
  mutations,
  getters,
  actions,
  // store
})
