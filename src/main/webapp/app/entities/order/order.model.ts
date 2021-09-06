import * as dayjs from 'dayjs';
import { IOrderLine } from 'app/entities/order-line/order-line.model';
import { IClient } from 'app/entities/client/client.model';

export interface IOrder {
  id?: number;
  idOrder?: number | null;
  totalPrice?: number | null;
  datePurchase?: dayjs.Dayjs | null;
  bill?: boolean | null;
  orderLines?: IOrderLine[] | null;
  client?: IClient | null;
  client?: IClient | null;
  orderLines?: IOrderLine[] | null;
}

export class Order implements IOrder {
  constructor(
    public id?: number,
    public idOrder?: number | null,
    public totalPrice?: number | null,
    public datePurchase?: dayjs.Dayjs | null,
    public bill?: boolean | null,
    public orderLines?: IOrderLine[] | null,
    public client?: IClient | null,
    public client?: IClient | null,
    public orderLines?: IOrderLine[] | null
  ) {
    this.bill = this.bill ?? false;
  }
}

export function getOrderIdentifier(order: IOrder): number | undefined {
  return order.id;
}
