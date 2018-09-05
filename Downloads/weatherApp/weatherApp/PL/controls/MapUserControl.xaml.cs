using PLWPF.viewModels;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Data;
using System.Windows.Documents;
using System.Windows.Input;
using System.Windows.Media;
using System.Windows.Media.Imaging;
using System.Windows.Navigation;
using System.Windows.Shapes;

namespace PLWPF.controls
{
    /// <summary>
    /// Interaction logic for MapUserControl.xaml
    /// </summary>
    public partial class MapUserControl : UserControl
    {
        public MapVM mapVM { get; set; }
        //WeeklyUserControl mini = new WeeklyUserControl();

        public MapUserControl()
        {
            InitializeComponent();
            mapVM = new MapVM();
            DataContext = mapVM;
            //this.Mini.Content = mini;

        }
    }
}
