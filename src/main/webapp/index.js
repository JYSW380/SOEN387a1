const app = document.querySelector('.app')
const darkmode = document.querySelector('.darkmode')
const sendbtn = document.querySelector('.sendbtn')
const msginput = document.querySelector('.maininp')
const personinp = document.querySelector('.personinp')
const clientnameinp = document.querySelector('.clientnameinp')

const months = ["January","February","March","April","May","June","July","August","September","October","November","December"]

function getDate() {
  let d = new Date()
  return months[d.getMonth()] + " "+ d.getDate() +", "+ d.getFullYear()
}
function getTime() {
  let d = new Date()
  return (d.getHours()>12?(d.getHours()-6):d.getHours()) +":"+(d.getMinutes()<10?("0"+d.getMinutes()):d.getMinutes())+":"+(d.getSeconds()<10?"0"+d.getSeconds():d.getSeconds())+(d.getHours()<12?"AM":"PM")
}
document.querySelector('.currentdate').innerHTML = getDate()

let darkclick = false
darkmode.onclick = () => {
  if(darkclick == false) {
    app.style.background = '#00090f'
    document.querySelector('.sidebar h2').style.color = '#eee'
    document.querySelectorAll('.sidebar h6 span').forEach(el => el.style.color = '#555')
    document.querySelectorAll('.menuicons i').forEach(el => el.style.color = '#eee')
    document.querySelector('.inputcont').style.background = '#222'
    document.querySelectorAll('.msgcont .msg').forEach(el => el.style.background = '#222')
    darkclick = true
  }
  else {
    app.style.background = ''
    document.querySelector('.sidebar h2').style.color = ''
    document.querySelectorAll('.sidebar h6 span').forEach(el => el.style.color = '')
    document.querySelectorAll('.menuicons i').forEach(el => el.style.color = '')
    document.querySelector('.inputcont').style.background = ''
    document.querySelectorAll('.msgcont .msg').forEach(el => el.style.background = '')
    darkclick = false
  } 
}



















