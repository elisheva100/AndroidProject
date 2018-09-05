using PLWPF.command;
using PLWPF.controls;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Controls;

namespace PLWPF.viewModels
{
    public class MainVM: INotifyPropertyChanged
    {
        public event PropertyChangedEventHandler PropertyChanged;
        public Button_Command ChangeView { get; set; }
        public CurrentUserControl currentUser { get; set; } 
        public WeeklyUserControl weekUser { get; set; }
        public MapUserControl mapUser { get; set; }

        private UserControl general;        
        public UserControl General { get {return general; }
            set
            {
                if (general == value)
                    return;
                general = value;

                if (PropertyChanged != null)
                    PropertyChanged(this, new PropertyChangedEventArgs("General"));
            }
        }

        public MainVM()
        {
            ChangeView = new Button_Command();
            ChangeView.CanExecuteChanged += ChangeView_CanExecuteChanged;
            currentUser = new CurrentUserControl();
            weekUser = new WeeklyUserControl();
            mapUser = new MapUserControl();
            General = currentUser;
        }


        private void ChangeView_CanExecuteChanged(object sender, EventArgs e)
        {
            if ((string)sender == "today")
                General = currentUser;
            else if ((string)sender == "days")
            { 
                General = new WeeklyUserControl();
                General=weekUser;
            }
            else if ((string)sender == "map")
            {
                General = new MapUserControl();
                General = mapUser;
            }
        }
    }
}
