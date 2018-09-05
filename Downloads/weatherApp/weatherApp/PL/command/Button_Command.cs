using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Input;

namespace PLWPF.command
{
    public class Button_Command : ICommand
    {
        public event EventHandler CanExecuteChanged;
       // public event EventHandler CanExecuteChanged2;

        public bool CanExecute(object parameter)
        {
            return true;
        }

        public void Execute(object parameter)
        { 
            //if((string)parameter== "today" || (string)parameter =="days" || (string)parameter =="map")
                CanExecuteChanged.Invoke(parameter, new EventArgs());
            //else CanExecuteChanged2.Invoke(parameter, new EventArgs());
        }
    }
}
